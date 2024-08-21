package training.commands;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import training.ModuleConstants;
import training.Robot;
import training.subsystems.Module;
import utils.joysticks.SmartJoystick;

public class MoveAngularByPosition extends Command {

    private Module module;
    private SmartJoystick joystick;
    private Rotation2d position;

    public MoveAngularByPosition(Robot robot, SmartJoystick joystick, Rotation2d position) {
        this.module = robot.getModule();
        this.joystick = joystick;
        this.position = position;
        addRequirements(module);
    }


    @Override
    public void execute() {
        module.setAngularMotorByPosition(position);
    }

    @Override
    public boolean isFinished() {
        return module.isAtPosition(position);
    }

    @Override
    public void end(boolean interrupted) {
        module.stopAngularMotor();
    }
}
