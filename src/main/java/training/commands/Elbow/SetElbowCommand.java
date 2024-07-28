package training.commands.Elbow;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import training.subsystems.Elbow.Elbow;

public class SetElbowCommand extends Command {
    private final Elbow elbowSubsystem;
    private final Rotation2d targetAngle;

    public SetElbowCommand(Rotation2d angle) {
        this.targetAngle = angle;
        this.elbowSubsystem = Elbow.getInstance();
    }

    @Override
    public void execute() {
        elbowSubsystem.setTargetAngle(targetAngle);
    }

    @Override
    public boolean isFinished() {
        return elbowSubsystem.isAtAngle(targetAngle);
    }
}
