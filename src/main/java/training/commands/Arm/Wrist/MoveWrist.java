package training.commands.Arm.Wrist;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import training.subsystems.Arm.Wrist.Wrist;

public class MoveWrist extends Command {

    private final Wrist wrist;

    private final Rotation2d targetPosition;

    public MoveWrist(Wrist wrist, Rotation2d targetPosition){
        this.wrist = Wrist.getInstance();
        this.targetPosition = targetPosition;
    }

    @Override
    public void initialize() {
        wrist.goTo(targetPosition);
    }

    @Override
    public boolean isFinished() {
        return wrist.isAtPosition(targetPosition);
    }

    @Override
    public void end(boolean interrupted) {
        wrist.stop();
    }
}
