package training.commands;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import org.littletonrobotics.junction.Logger;
import training.Robot;
import training.subsystems.Arm.Elbow.Elbow;
import training.subsystems.Arm.Elbow.ElbowConstants;

public class MoveElbowByPosition extends Command {

    private final Elbow elbow;

    private final Rotation2d position;

    public MoveElbowByPosition(Robot robot, Rotation2d position) {
        this.elbow = robot.getElbow();
        this.position = position;
        addRequirements(elbow);
    }


    @Override
    public void execute() {
        elbow.moveToAngle(position);
        Logger.recordOutput("Elbow/PID Difference", Math.abs(elbow.getPosition().getRotations() - position.getRotations()));
    }

    @Override
    public boolean isFinished() {
        return elbow.isAtAngle(position);
    }

    @Override
    public void end(boolean interrupted) {
        elbow.standInPlace();
    }
}
