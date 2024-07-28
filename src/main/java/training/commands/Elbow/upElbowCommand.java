package training.commands.Elbow;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import training.subsystems.Elbow.Elbow;

public class upElbowCommand extends Command {
    private final Elbow elbowSubsystem;
    private final Rotation2d addedAngle;
    private final Rotation2d originalAngle;

    public upElbowCommand(Rotation2d angle) {
        elbowSubsystem = Elbow.getInstance();
        addRequirements(elbowSubsystem);
        addedAngle = angle;
        originalAngle = elbowSubsystem.getMotorAngle();
    }

    public upElbowCommand() {
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
