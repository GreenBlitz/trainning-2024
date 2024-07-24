package training.commands;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import org.littletonrobotics.junction.Logger;
import training.ModuleConstants;
import training.Robot;
import training.subsystems.Module;
import utils.joysticks.Axis;
import utils.joysticks.SmartJoystick;

public class MoveAngularByPosition extends Command {
    private Module module;
    private Rotation2d position;

    public MoveAngularByPosition(Robot robot, Rotation2d position) {
        this.module = robot.getModule();
        this.position = position;
        addRequirements(module);
    }

    @Override
    public void execute() {
        module.setAngularMotorByPosition(position);
    }

    @Override
    public boolean isFinished() {
        return Math.abs(module.getAngularPosition().getDegrees() - position.getDegrees()) <= ModuleConstants.ANGULAR_TOLERANCE.getDegrees();
    }

    @Override
    public void end(boolean interrupted) {
        module.stopAngularMotor();
        Logger.recordOutput("Angular position of module",module.getAngularPosition());
    }
}
