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
        Command out = new SequentialCommandGroup(UpElbowCommand(), new WaitCommand(0.1), DownElbowCommand());
        out.addRequirements(elbowSubsystem);
        return out;
    }

    public Command GoToPickUpPositionCommand() {
        return new InstantCommand(() -> new SetElbowCommand(PICKUP_POSITION), elbowSubsystem);
    }

    public Command GoToScorePositionCommand() {
        return new InstantCommand(() -> new SetElbowCommand(SCORE_POSITION), elbowSubsystem);
    }

    public Command LockElbowInPlaceCommand() {
        return new InstantCommand(elbowSubsystem::LockElbowInPlace, elbowSubsystem);
    }

    public Command UpElbowCommand() {
        return new InstantCommand(() -> new SetElbowCommand(DEFAULT_LIFT_DEG), elbowSubsystem);
    }

    public Command DownElbowCommand() {
        return new InstantCommand(() -> new SetElbowCommand(DEFAULT_LIFT_DEG.times(-1)), elbowSubsystem);
    }
}
