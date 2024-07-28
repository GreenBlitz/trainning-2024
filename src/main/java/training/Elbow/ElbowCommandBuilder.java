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
        return new SequentialCommandGroup(UpElbowCommand(), new WaitCommand(0.1), DownElbowCommand());
    }

    public Command GoToPickUpPositionCommand() {
        return new InstantCommand(() -> new SetElbowCommand(PICKUP_POSITION));
    }

    public Command GoToScorePositionCommand() {
        return new InstantCommand(() -> new SetElbowCommand(SCORE_POSITION));
    }

    public Command LockElbowInPlaceCommand() {
        return new InstantCommand(elbowSubsystem::LockElbowInPlace);
    }

    public Command UpElbowCommand() {
        return new InstantCommand(() -> new SetElbowCommand(DEFAULT_LIFT_DEG));
    }

    public Command DownElbowCommand() {
        return new InstantCommand(() -> new SetElbowCommand(DEFAULT_LIFT_DEG.times(-1)));
    }
}
