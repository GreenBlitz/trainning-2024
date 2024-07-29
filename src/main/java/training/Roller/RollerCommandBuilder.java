package training.Roller;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import static training.Roller.RollerConstants.ROLLER_ROLLING_TIME_SEC;

public class RollerCommandBuilder {
    private final Roller rollerSubsystem;

    public RollerCommandBuilder() {
        this.rollerSubsystem = Roller.getInstance();
    }

    public Command RollerStopCommand() {
        return new InstantCommand(rollerSubsystem::stop, rollerSubsystem);
    }

    public Command NoteOutCommand() {
        return new InstantCommand(() -> RunRollerForwardCommand().withTimeout(ROLLER_ROLLING_TIME_SEC), rollerSubsystem);
    }

    public Command RunRollerBackwardCommand() {
        return new InstantCommand(rollerSubsystem::runBackward, rollerSubsystem);
    }

    public Command RunRollerForwardCommand() {
        return new InstantCommand(rollerSubsystem::runForward, rollerSubsystem);
    }
}
