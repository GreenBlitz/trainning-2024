package training.commands.Arm;

import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import training.subsystems.Arm.ElbowSubsystem;

public class MoveElbow extends Command {
    private final ElbowSubsystem elbow;
    private final Rotation2d targetPosition;

    public MoveElbow(ElbowSubsystem elbow, Rotation2d targetPosition){
        this.elbow = elbow;
        this.targetPosition = targetPosition;
    }

    @Override
    public void initialize() {
        elbow.setSpeed(ArmConstants.DEFAULT_SPEED);
    }

    @Override
    public boolean isFinished() {
        return elbow.isAtPosition(targetPosition, ArmConstants.ELBOW_TOLERANCE);
    }

    @Override
    public void end(boolean interrupted) {
        elbow.stop();

    }
}
