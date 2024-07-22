package commands.Elbow;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import subsystems.ElbowSubsystem;

public class UpElbow extends Command {
    private final ElbowSubsystem elbowSubsystem = new ElbowSubsystem();
    private final Rotation2d addedAngle;

    public UpElbow(Rotation2d angle) {
        addedAngle = angle;
    }

    public UpElbow() {
        addedAngle = Rotation2d.fromDegrees(Constants.DEFAULT_LIFT_DEG);
    }

    @Override
    public void initialize() {
        elbowSubsystem.addToAngle(addedAngle);
    }
}
