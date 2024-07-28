package training.Roller.RollerCommands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import training.Roller.Roller;

public class RollerCommandBuilder extends Command {
    private final Roller roller;

    public RollerCommandBuilder() {
        this.roller = Roller.getInstance();
        addRequirements(roller);
    }

    public Command RollerStopCommand() {
        return new InstantCommand(roller::stop);
    }
}
