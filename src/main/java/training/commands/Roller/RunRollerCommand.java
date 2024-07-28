package training.commands.Roller;

import edu.wpi.first.wpilibj2.command.Command;
import training.subsystems.Roller.Roller;

public class RunRollerCommand extends Command {
    private final Roller roller;

    public RunRollerCommand() {
        roller = Roller.getInstance();
        addRequirements(roller);
    }

    @Override
    public void execute() {
        addRequirements(roller);
        roller.run();
    }
}
