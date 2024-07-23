package training.commands.ArmCommands;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import training.subsystems.ArmSubsystems.Arm_constants;
import training.subsystems.ArmSubsystems.Elbow;

public class moveElbow extends Command {

    private Elbow elbow;
    private Rotation2d targetPosition;

    public moveElbow(Elbow elbow, Rotation2d targetPosition){
        this.elbow=elbow;
        this.targetPosition=targetPosition;
    }

    public void initialize() {
        elbow.moveElbow(0.3);
    }

    public boolean isFinished() {
        return elbow.isAtTarget(targetPosition, Arm_constants.ELBOW_TOLERANCE);
    }

    public void end(boolean interrupted) {
        elbow.stopElbow();
    }
}
