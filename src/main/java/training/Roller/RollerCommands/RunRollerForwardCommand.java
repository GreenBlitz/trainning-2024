package training.Roller.RollerCommands;

import edu.wpi.first.wpilibj2.command.Command;
import training.Roller.Roller;

public class RunRollerForwardCommand extends Command {
    private final Roller roller;

    public RunRollerForwardCommand() {
        this.roller = Roller.getInstance();
        addRequirements(roller);
    }

    @Override
    public void execute() {
        roller.runForward();
    }
}
