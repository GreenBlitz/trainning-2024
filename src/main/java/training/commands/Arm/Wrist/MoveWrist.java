package training.commands.Arm.Wrist;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import training.subsystems.Arm.Wrist.WristSubsystem;

public class MoveWrist extends Command {
    private final WristSubsystem wrist;
    private final Rotation2d targetPosition;

    public MoveWrist(WristSubsystem wrist, Rotation2d targetPosition){
        this.wrist = wrist;
        this.targetPosition = targetPosition;
    }

    @Override
    public void initialize() {
        wrist.setSpeed(WristConstants.DEFAULT_SPEED);
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
