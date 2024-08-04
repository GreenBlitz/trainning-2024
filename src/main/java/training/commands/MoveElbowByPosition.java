package training.commands;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import org.littletonrobotics.junction.Logger;
import training.subsystems.Elbow.ElbowConstants;
import training.Robot;
import training.subsystems.Elbow.Elbow;

public class MoveElbowByPosition extends Command {
    private final Elbow elbow;
    private final Rotation2d position;
    public MoveElbowByPosition(Robot robot, Rotation2d position) {
        this.elbow = robot.getElbow();
        addRequirements(elbow);
        this.position = position;
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        elbow.moveToAngle(position);
    }

    @Override
    public boolean isFinished() {
        return Math.abs(elbow.getPosition().getRotations() - position.getRotations()) <= ElbowConstants.ANGULAR_TOLERANCE.getRotations();
    }

    @Override
    public void end(boolean interrupted) {
        elbow.stopMotor();
        Logger.recordOutput(elbow.getPosition().toString());
    }
}
