package training.commands.ArmCommands;

import edu.wpi.first.math.geometry.Rotation2d;
import training.subsystems.ArmSubsystems.WristPackage.Wrist;
import training.subsystems.ArmSubsystems.WristPackage.WristConstants;

public class MoveWrist {
    private final Wrist wrist;
    private final Rotation2d targetPosition;

    public MoveWrist(Rotation2d targetPosition) {
        this.wrist = Wrist.getInstance();
        this.targetPosition = targetPosition;
    }

    public void initialize() {
        wrist.move(targetPosition);
    }

    public boolean isFinished() {
        return wrist.isAtTargetAngle(targetPosition, WristConstants.WRIST_TOLERANCE_DEGREES);
    }

    public void end(boolean interrupted) {
        wrist.stop();
    }
}
