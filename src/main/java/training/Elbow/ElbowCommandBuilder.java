package training.Elbow;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.FunctionalCommand;

import static training.Elbow.ElbowConstants.*;

public class ElbowCommandBuilder {
    private final Elbow elbowSubsystem;

    public Command MoveElbowToAngle(Rotation2d targetAngle) {
        return new FunctionalCommand(
                () -> {},
                () -> elbowSubsystem.setTargetAngle(targetAngle),
                (interrupted) -> {},
                () -> elbowSubsystem.isAtAngle(targetAngle),
                elbowSubsystem
        );
    }

    public ElbowCommandBuilder() {
        this.elbowSubsystem = Elbow.getInstance();
    }

    public Command LiftElbow() {
        Command output = new SequentialCommandGroup(UpElbow(), new WaitCommand(DEFAULT_TIME_IN_AIR_ELBOW_SECONDS), DownElbow());
        output.addRequirements(elbowSubsystem);
        return output;
    }

    public Command GoToPickUpPosition() {
        return new InstantCommand(() -> MoveElbowToAngle(PICKUP_POSITION_ELBOW), elbowSubsystem);
    }

    public Command GoToScorePosition() {
        return new InstantCommand(() -> MoveElbowToAngle(SCORE_POSITION_ELBOW), elbowSubsystem);
    }

    public Command LockElbowInPlaceCommand() {
        return new InstantCommand(elbowSubsystem::LockElbowInPlace, elbowSubsystem);
    }

    public Command UpElbow() {
        return new InstantCommand(() -> MoveElbowToAngle(DEFAULT_LIFT_DEGREES), elbowSubsystem);
    }

    public Command DownElbow() {
        return new InstantCommand(() -> MoveElbowToAngle(DEFAULT_LIFT_DEGREES.times(-1)), elbowSubsystem);
    }
}
