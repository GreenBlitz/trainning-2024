package training.commands.Elbow;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

import static training.commands.Elbow.Constants.PICKUP_POSITION;
import static training.commands.Elbow.Constants.SCORE_POSITION;

public class ElbowCommandBuilder {
    public Command LiftElbowCommand() {
        return new SequentialCommandGroup(new UpElbowCommand(), new WaitCommand(0.1), new DownElbowCommand());
    }
    public Command GoToPickUpPositionCommand() {
        return new InstantCommand(() -> new SetElbowCommand(PICKUP_POSITION));
    }
    public Command GoToScorePositionCommand() {
        return new InstantCommand(() -> new SetElbowCommand(SCORE_POSITION));
    }
}
