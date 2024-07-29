package training.Elbow;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

import static training.Elbow.ElbowConstants.*;

public class ElbowCommandBuilder {
    private final Elbow elbowSubsystem;

    public ElbowCommandBuilder() {
        this.elbowSubsystem = Elbow.getInstance();
    }

    public Command LiftElbow() {
        Command output = new SequentialCommandGroup(UpElbow(), new WaitCommand(DEFAULT_TIME_IN_AIR_ELBOW_SECONDS), DownElbow());
        output.addRequirements(elbowSubsystem);
        return output;
    }

    public Command GoToPickUpPosition() {
        return new InstantCommand(() -> new MoveElbowToAngle(PICKUP_POSITION_ELBOW), elbowSubsystem);
    }

    public Command GoToScorePosition() {
        return new InstantCommand(() -> new MoveElbowToAngle(SCORE_POSITION_ELBOW), elbowSubsystem);
    }

    public Command LockElbowInPlaceCommand() {
        return new InstantCommand(elbowSubsystem::LockElbowInPlace, elbowSubsystem);
    }

    public Command UpElbow() {
        return new InstantCommand(() -> new MoveElbowToAngle(DEFAULT_LIFT_DEGREES), elbowSubsystem);
    }

    public Command DownElbow() {
        return new InstantCommand(() -> new MoveElbowToAngle(DEFAULT_LIFT_DEGREES.times(-1)), elbowSubsystem);
    }
}
