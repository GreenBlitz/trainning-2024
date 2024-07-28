package training.commands.Roller;

import edu.wpi.first.wpilibj2.command.Command;
import training.subsystems.Roller.Roller;

public class RunRollerBackwardsCommand extends Command {
    private final Roller roller;

    public RunRollerBackwardsCommand() {
        roller = Roller.getInstance();
        addRequirements(roller);
    }

    @Override
    public void execute() {
        addRequirements(roller);
        roller.runForward();
    }
}
