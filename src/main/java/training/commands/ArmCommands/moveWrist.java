package training.commands.ArmCommands;

import edu.wpi.first.math.geometry.Rotation2d;
import training.subsystems.ArmSubsystems.Arm_constants;
import training.subsystems.ArmSubsystems.Wrist;

public class moveWrist {
    private Wrist wrist;
    private Rotation2d targetPosition;

    public moveWrist(Wrist wrist, Rotation2d targetPosition){
        this.wrist=wrist;
        this.targetPosition=targetPosition;
    }


    public void initialize() {
        wrist.moveWrist(0.3);
    }

    public boolean isFinished() {
        return wrist.isAtTarget(targetPosition, Arm_constants.WRIST_TOLERANCE);
    }

    public void end(boolean interrupted) {
        wrist.stopElbow();
    }
}
