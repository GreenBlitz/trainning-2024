package training.commands.Roller;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import training.subsystems.Roller.Roller;

public class StopRollerCommand extends Command {
    private final Roller roller;

    public StopRollerCommand() {
        roller = Roller.getInstance();
        addRequirements(roller);
    }

    @Override
    public void execute() {
        addRequirements(roller);
        roller.stop();
    }

    @Override
    public boolean isFinished() {
        try {
            wait(5);
        } catch (InterruptedException e) {
            SmartDashboard.putString("got error on stopRollerCommand InterruptedException: ", e.getMessage());
        }
        return true;
    }

}
