package commands.Elbow;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import subsystems.ElbowSubsystem;

public class UpElbow extends Command {
    private final ElbowSubsystem elbowSubsystem = new ElbowSubsystem();
    private final Rotation2d addedAngle;
    private final Rotation2d originalAngle;

    public UpElbow(Rotation2d angle) {
        addRequirements(elbowSubsystem);
        addedAngle = angle;
        originalAngle = elbowSubsystem.getMotorAngle();
    }

    public UpElbow() {
        addRequirements(elbowSubsystem);
        addedAngle = Rotation2d.fromDegrees(Constants.DEFAULT_LIFT_DEG);
        originalAngle = elbowSubsystem.getMotorAngle();
    }

    @Override
    public void initialize() {
        elbowSubsystem.addToAngle(addedAngle);
    }

    @Override
    public boolean isFinished() {
        return elbowSubsystem.isAtAngle(originalAngle.plus(addedAngle));
    }
}
