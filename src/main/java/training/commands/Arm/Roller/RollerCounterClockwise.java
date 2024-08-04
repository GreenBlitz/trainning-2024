package training.commands.Arm.Roller;
import edu.wpi.first.wpilibj2.command.Command;
import training.subsystems.Arm.Roller.RollerSubsystem;

public class RollerCounterClockwise extends Command {
    private final RollerSubsystem roller;

    public RollerCounterClockwise(){
        this.roller = RollerSubsystem.getInstance();
    }

    @Override
    public void initialize() {
        roller.counterClockwise();
    }

    @Override
    public void end(boolean interrupted) {
        roller.stop();
    }
}
