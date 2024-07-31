package training.commands.Arm.Roller;
import edu.wpi.first.wpilibj2.command.Command;
import training.subsystems.Arm.Roller.RollerSubsystem;

public class RollerReverse extends Command {
    private final RollerSubsystem roller;

    public RollerReverse(RollerSubsystem roller){
        this.roller = roller;
    }

    @Override
    public void initialize() {
        roller.setPower(-RollerConstants.DEFAULT_SPEED_BACKWARDS);
    }

    @Override
    public void end(boolean interrupted) {
        roller.stop();
    }
}
