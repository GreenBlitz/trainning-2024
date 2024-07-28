package training.commands.Roller;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import static training.commands.Roller.Constants.ROLLER_ROLLING_TIME_SEC;

public class NoteOutCommand extends SequentialCommandGroup {
    public NoteOutCommand() {
        addCommands(new RunRollerCommand().withTimeout(ROLLER_ROLLING_TIME_SEC), new StopRollerCommand());
    }
}
