package training.commands.Arm;

import com.fasterxml.jackson.databind.cfg.MutableConfigOverride;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import training.subsystems.Arm.ElbowSubsystem;

public class MoveElbow extends Command {
    private ElbowSubsystem elbow;
    private Rotation2d targetPosition;

    public MoveElbow(ElbowSubsystem elbow, Rotation2d targetPosition){
        this.elbow = elbow;
        this.targetPosition = targetPosition;
    }

    @Override
    public void initialize() {
        elbow.setSpeed(Constants.DEFAULT_SPEED);
    }

    @Override
    public boolean isFinished() {
        return elbow.isAtPosition(targetPosition, Constants.ELBOW_TOLERANCE);
    }

    @Override
    public void end(boolean interrupted) {
        elbow.stop();
    }
}
