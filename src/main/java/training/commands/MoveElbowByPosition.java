package training.commands;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import training.ElbowConstants;
import training.ModuleConstants;
import training.Robot;
import training.subsystems.Elbow;
import training.subsystems.Module;
import utils.joysticks.SmartJoystick;

public class MoveElbowByPosition extends Command {
    private Elbow elbow;
    private Rotation2d position;
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
        elbow.setMotorByPosition(position);
    }

    @Override
    public boolean isFinished() {
        return Math.abs(elbow.getPosition().getRotations() - position.getRotations()) <= ElbowConstants.ANGULAR_TOLERANCE.getRotations();
    }

    @Override
    public void end(boolean interrupted) {
        elbow.stopMotor();
        System.out.println(elbow.getPosition());
    }
}
