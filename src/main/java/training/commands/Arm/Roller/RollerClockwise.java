package training.commands.Arm.Roller;
import edu.wpi.first.wpilibj2.command.Command;
import training.subsystems.Arm.Roller.RollerSubsystem;

public class RollerClockwise extends Command {
    private final RollerSubsystem roller;

    public RollerClockwise(RollerSubsystem roller){
        this.roller = RollerSubsystem.getInstance();
    }

    @Override
    public void initialize() {
        roller.clockwise();
    }

    @Override
    public void end(boolean interrupted) {
        roller.stop();
    }
}
