package training.Roller;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;

import static training.Roller.RollerConstants.DEFAULT_ROLLING_TIME_SECONDS;

public class RollerCommandBuilder {
    private final Roller rollerSubsystem;

    public RollerCommandBuilder() {
        this.rollerSubsystem = new Roller();
    }

    public Command RollerStop() {
        return new InstantCommand(rollerSubsystem::stop, rollerSubsystem);
    }

    public Command noteOut() {
        return rollForward().withTimeout(DEFAULT_ROLLING_TIME_SECONDS);
    }

    public Command rollBackward() {
        return new InstantCommand(rollerSubsystem::runBackward, rollerSubsystem);
    }

    public Command rollForward() {
        return new InstantCommand(rollerSubsystem::runForward, rollerSubsystem);
    }

}
