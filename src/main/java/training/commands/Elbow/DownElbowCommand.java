package training.commands.Elbow;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import training.subsystems.Elbow.Elbow;

public class DownElbowCommand extends Command {
    private final Elbow elbowSubsystem;
    private final Rotation2d subtractedAngle;

    public DownElbowCommand(Rotation2d angle) {
        elbowSubsystem = Elbow.getInstance();
        addRequirements(elbowSubsystem);
        subtractedAngle = angle;
    }

    public DownElbowCommand() {
        elbowSubsystem = Elbow.getInstance();
        addRequirements(elbowSubsystem);
        subtractedAngle = Rotation2d.fromDegrees(Constants.DEFAULT_LIFT_DEG);
    }

    @Override
    public void initialize() {
        elbowSubsystem.subtractFromAngle(subtractedAngle);
    }
}
