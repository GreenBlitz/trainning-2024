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

    public Command LiftElbowCommand() {
        Command output = new SequentialCommandGroup(UpElbowCommand(), new WaitCommand(DEFAULT_TIME_IN_AIR_ELBOW_SECONDS), DownElbowCommand());
        output.addRequirements(elbowSubsystem);
        return output;
    }

    public Command GoToPickUpPositionCommand() {
        return new InstantCommand(() -> new MoveToAngleCommand(PICKUP_POSITION), elbowSubsystem);
    }

    public Command GoToScorePositionCommand() {
        return new InstantCommand(() -> new MoveToAngleCommand(SCORE_POSITION), elbowSubsystem);
    }

    public Command LockElbowInPlaceCommand() {
        return new InstantCommand(elbowSubsystem::LockElbowInPlace, elbowSubsystem);
    }

    public Command UpElbowCommand() {
        return new InstantCommand(() -> new MoveToAngleCommand(DEFAULT_LIFT_DEGREES), elbowSubsystem);
    }

    public Command DownElbowCommand() {
        return new InstantCommand(() -> new MoveToAngleCommand(DEFAULT_LIFT_DEGREES.times(-1)), elbowSubsystem);
    }
}
