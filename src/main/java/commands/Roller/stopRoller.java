package commands.Roller;

import edu.wpi.first.wpilibj2.command.Command;
import subsystems.RollerSubsystem;

public class stopRoller extends Command {
    private final RollerSubsystem roller = new RollerSubsystem();

    public stopRoller() {
        addRequirements(roller);
    }

    @Override
    public void execute() {
        addRequirements(roller);
        roller.stop();
    }
}
