package training.commands.Elbow;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import training.subsystems.Elbow.Elbow;

public class UpElbowCommand extends Command {
    private final Elbow elbowSubsystem;
    private final Rotation2d addedAngle;
    private final Rotation2d originalAngle;

    public UpElbowCommand(Rotation2d angle) {
        this.elbowSubsystem = Elbow.getInstance();
        this.addedAngle = angle;
        this.originalAngle = elbowSubsystem.getMotorAngle();
        addRequirements(elbowSubsystem);
    }

    public UpElbowCommand() {
        super();
        elbowSubsystem = Elbow.getInstance();
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
