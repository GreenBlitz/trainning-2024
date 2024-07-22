package commands.Elbow;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import subsystems.ElbowSubsystem;

public class DownElbow extends Command {
    private final ElbowSubsystem elbowSubsystem = new ElbowSubsystem();
    private final Rotation2d subtractedAngle;

    public DownElbow(Rotation2d angle) {
        addRequirements(elbowSubsystem);
        subtractedAngle = angle;
    }

    public DownElbow() {
        addRequirements(elbowSubsystem);
        subtractedAngle = Rotation2d.fromDegrees(Constants.DEFAULT_LIFT_DEG);
    }

    @Override
    public void initialize() {
        elbowSubsystem.subtractFromAngle(subtractedAngle);
    }
}
