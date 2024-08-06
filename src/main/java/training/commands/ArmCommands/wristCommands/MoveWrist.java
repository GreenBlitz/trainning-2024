package training.commands.ArmCommands.wristCommands;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import training.subsystems.ArmSubsystems.wristSubsystem.Wrist;
import training.subsystems.ArmSubsystems.wristSubsystem.WristConstants;

public class MoveWrist extends Command {

    private final Wrist wrist;
    private final Rotation2d targetPosition;

    public MoveWrist(Rotation2d targetPosition) {
        this.wrist = Wrist.getInstance();
        this.targetPosition = targetPosition;
    }

    public void initialize() {
        wrist.goToPosition(targetPosition);
    }

    public boolean isFinished() {
        return wrist.isAtTargetAngle(targetPosition, WristConstants.WRIST_TOLERANCE_DEGREES);
    }

}
