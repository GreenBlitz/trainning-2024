package training.commands.Roller;

import edu.wpi.first.wpilibj2.command.Command;
import training.subsystems.Roller.Roller;

public class runRollerCommand extends Command {
    private final Roller roller = Roller.getInstance();

    public runRollerCommand() {
        addRequirements(roller);
    }

    @Override
    public void execute() {
        addRequirements(roller);
        roller.run();
    }
}
