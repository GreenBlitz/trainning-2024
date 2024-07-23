package training.commands.Arm;

import com.fasterxml.jackson.databind.cfg.MutableConfigOverride;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import training.subsystems.Arm.WristSubsystem;

public class MoveWrist extends Command {
    private WristSubsystem wrist;
    private Rotation2d targetPosition;

    public MoveWrist(WristSubsystem wrist, Rotation2d targetPosition){
        this.wrist = wrist;
        this.targetPosition = targetPosition;
    }

    @Override
    public void initialize() {
        wrist.setSpeed(0.3);
    }

    @Override
    public boolean isFinished() {
        return wrist.isAtPosition(targetPosition, Constants.WRIST_TOLERANCE);
    }

    @Override
    public void end(boolean interrupted) {
        wrist.stop();
    }
}
