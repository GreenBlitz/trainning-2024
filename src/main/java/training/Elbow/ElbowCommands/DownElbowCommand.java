package training.Elbow.ElbowCommands;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import training.Elbow.Elbow;

public class DownElbowCommand extends Command {
    private final Elbow elbowSubsystem;
    private final Rotation2d subtractedAngle;

    public DownElbowCommand(Rotation2d angle) {
        this.elbowSubsystem = Elbow.getInstance();
        this.subtractedAngle = angle;
        addRequirements(elbowSubsystem);
    }

    public DownElbowCommand() {
        this.elbowSubsystem = Elbow.getInstance();
        this.subtractedAngle = Rotation2d.fromDegrees(Constants.DEFAULT_LIFT_DEG);
        addRequirements(elbowSubsystem);
    }

    @Override
    public void initialize() {
        elbowSubsystem.subtractFromAngle(subtractedAngle);
    }
}
