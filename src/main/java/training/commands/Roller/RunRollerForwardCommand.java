package training.commands.Roller;

import edu.wpi.first.wpilibj2.command.Command;
import training.subsystems.Roller.Roller;

public class RunRollerForwardCommand extends Command {
    private final Roller roller;

    public RunRollerForwardCommand() {
        roller = Roller.getInstance();
        addRequirements(roller);
    }

    @Override
    public void execute() {
        roller.runForward();
    }
}
