package training.commands.Arm.Roller;
import edu.wpi.first.wpilibj2.command.Command;
import training.subsystems.Arm.Roller.RollerSubsystem;

public class RollerForward extends Command {
    private final RollerSubsystem roller;

    public RollerForward(RollerSubsystem roller){
        this.roller = roller;
    }

    @Override
    public void initialize() {
        roller.setPower(RollerConstants.DEFAULT_SPEED_FORWARD);
    }

    @Override
    public void end(boolean interrupted) {
        roller.stop();
    }
}
