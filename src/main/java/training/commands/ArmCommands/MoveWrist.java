package training.commands.ArmCommands;

import edu.wpi.first.math.geometry.Rotation2d;
import training.subsystems.ArmSubsystems.Wrist;
import training.subsystems.ArmSubsystems.WristConstants;

public class MoveWrist {
    private final Wrist wrist;
    private final Rotation2d targetPosition;

    public MoveWrist(Wrist wrist, Rotation2d targetPosition){
        this.wrist=wrist;
        this.targetPosition=targetPosition;
    }


    public void initialize() {
        wrist.moveWrist(0.3);
    }

    public boolean isFinished() {
        return wrist.isAtTarget(targetPosition, WristConstants.WRIST_TOLERANCE);
    }

    public void end(boolean interrupted) {
        wrist.stopElbow();
    }
}
