package training.Roller;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;

import static training.Roller.RollerConstants.ROLLER_ROLLING_TIME_SECONDS;

public class RollerCommandBuilder {
    private final Roller rollerSubsystem;

    public RollerCommandBuilder() {
        this.rollerSubsystem = Roller.getInstance();
    }

    public Command RollerStop() {
        return new InstantCommand(rollerSubsystem::stop, rollerSubsystem);
    }

    public Command NoteOut() {
        return RunRollerForward().withTimeout(ROLLER_ROLLING_TIME_SECONDS);
    }

    public Command RunRollerBackward() {
        return new InstantCommand(rollerSubsystem::runBackward, rollerSubsystem);
    }

    public Command RunRollerForward() {
        return new InstantCommand(rollerSubsystem::runForward, rollerSubsystem);
    }
}
