package commands.Roller;

import edu.wpi.first.wpilibj2.command.Command;
import subsystems.RollerSubsystem;

public class runRoller extends Command {
    private final RollerSubsystem roller = new RollerSubsystem();

    @Override
    public void execute() {
        addRequirements(roller);
        roller.run();
    }
}
