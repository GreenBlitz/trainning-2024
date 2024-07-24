package training.commands.Roller;

import edu.wpi.first.wpilibj2.command.Command;
import training.subsystems.RollerSubsystem;

public class stopRollerCommand extends Command {
    private final RollerSubsystem roller = RollerSubsystem.getInstance();

    public stopRollerCommand() {
        addRequirements(roller);
    }

    @Override
    public void execute() {
        addRequirements(roller);
        roller.stop();
    }
}
