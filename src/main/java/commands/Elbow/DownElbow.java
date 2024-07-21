package commands.Elbow;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import subsystems.Elbow;

public class DownElbow extends Command {
    private final Elbow elbowSubsystem = new Elbow();
    private Rotation2d subtractedAngle;

    public DownElbow(Rotation2d angle) {
        subtractedAngle = angle;
    }

    public DownElbow() {
        subtractedAngle = Rotation2d.fromDegrees(Constants.DEFAULT_LIFT_DEG);
    }

    @Override
    public void initialize() {
        elbowSubsystem.subtractFromAngle(Rotation2d.fromDegrees(Constants.DEFAULT_LIFT_DEG));
    }
}
