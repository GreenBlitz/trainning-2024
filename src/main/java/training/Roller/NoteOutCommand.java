package training.Roller;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import static training.Roller.RollerConstants.ROLLER_ROLLING_TIME_SEC;


public class NoteOutCommand extends SequentialCommandGroup {
    public NoteOutCommand() {
        addCommands(new RunRollerForwardCommand().withTimeout(ROLLER_ROLLING_TIME_SEC), new RollerCommandBuilder());
    }
}
