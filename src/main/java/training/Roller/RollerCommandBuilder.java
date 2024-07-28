package training.Roller;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import static training.Roller.RollerConstants.ROLLER_ROLLING_TIME_SEC;

public class RollerCommandBuilder extends Command {
    private final Roller roller;

    public RollerCommandBuilder() {
        this.roller = Roller.getInstance();
        addRequirements(roller);
    }

    public Command RollerStopCommand() {
        return new InstantCommand(roller::stop);
    }

    public Command NoteOutCommand() {
        return new SequentialCommandGroup(new RunRollerForwardCommand().withTimeout(ROLLER_ROLLING_TIME_SEC), new RollerCommandBuilder());
    }

    public Command RunRollerBackwardCommand() {
        return new InstantCommand(roller::runBackward);
    }

    public Command RunRollerForwardCommand() {
        return new InstantCommand(roller::runForward);
    }
}
