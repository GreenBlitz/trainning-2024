package training.Elbow.ElbowCommands;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import training.Elbow.Elbow;

import static training.Elbow.ElbowConstants.DEFAULT_LIFT_DEG;

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
        this.elbowSubsystem = Elbow.getInstance();
        this.addedAngle = Rotation2d.fromDegrees(DEFAULT_LIFT_DEG);
        this.originalAngle = elbowSubsystem.getMotorAngle();
        addRequirements(elbowSubsystem);
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
