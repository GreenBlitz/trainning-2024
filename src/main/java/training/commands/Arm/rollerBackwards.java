package training.commands.Arm;

import edu.wpi.first.wpilibj2.command.Command;
import training.subsystems.Arm.RollerSubsystem;

public class rollerBackwards extends Command {
    private RollerSubsystem roller;

    public rollerBackwards(RollerSubsystem roller){
        this.roller = roller;
    }

    @Override
    public void initialize() {
        roller.setSpeed(-Constants.DEFAULT_SPEED);
    }

    @Override
    public void end(boolean interrupted) {
        roller.stop();
    }
}
