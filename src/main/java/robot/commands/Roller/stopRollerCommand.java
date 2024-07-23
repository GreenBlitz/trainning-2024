package robot.commands.Roller;

import edu.wpi.first.wpilibj2.command.Command;
import robot.subsystems.RollerSubsystem;

public class stopRollerCommand extends Command {
    private final RollerSubsystem roller = new RollerSubsystem();

    public stopRollerCommand() {
        addRequirements(roller);
    }

    @Override
    public void execute() {
        addRequirements(roller);
        roller.stop();
    }
}
