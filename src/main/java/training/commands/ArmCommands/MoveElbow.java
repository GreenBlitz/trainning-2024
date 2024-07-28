package training.commands.ArmCommands;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import training.subsystems.ArmSubsystems.Elbow;
import training.subsystems.ArmSubsystems.ElbowConstants;

public class MoveElbow extends Command {

    private final Elbow elbow;
    private final Rotation2d targetPosition;

    public MoveElbow(Elbow elbow, Rotation2d targetPosition){
        this.elbow=elbow;
        this.targetPosition=targetPosition;
    }

    public void initialize() {
        elbow.moveElbow(targetPosition);
    }

    public boolean isFinished() {
        return elbow.isAtTarget(targetPosition, ElbowConstants.ELBOW_TOLERANCE);
    }

    public void end(boolean interrupted) {
        elbow.stayAtPosition();
    }
}
