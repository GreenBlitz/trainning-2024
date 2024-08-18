package training.commands;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import org.littletonrobotics.junction.Logger;
import training.Robot;
import training.subsystems.Arm.Wrist.WristConstants;
import training.subsystems.Arm.Wrist.Wrist;

public class MoveWristByPosition extends Command {
    private final Wrist wrist;

    private final Rotation2d position;
    public MoveWristByPosition(Robot robot, Rotation2d position) {
        this.wrist = robot.getWrist();
        addRequirements(wrist);
        this.position = position;
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        wrist.moveToAngle(position);
        Logger.recordOutput("Wrist Distance", Math.abs(wrist.getPosition().getRotations() - position.getRotations()));
    }

    @Override
    public boolean isFinished() {
        return Math.abs(wrist.getPosition().getRotations() - position.getRotations()) % 1 <= WristConstants.ANGULAR_TOLERANCE.getRotations();
    }

    @Override
    public void end(boolean interrupted) {
        wrist.stopMotor();
        wrist.standInPlace();
    }
}
