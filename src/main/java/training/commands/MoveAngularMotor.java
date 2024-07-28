package training.commands;

import edu.wpi.first.wpilibj2.command.Command;
import training.Robot;
import training.subsystems.Module;
import utils.joysticks.Axis;
import utils.joysticks.SmartJoystick;

public class MoveAngularMotor extends Command{
    private Module module;
    private SmartJoystick joystick;
    public MoveAngularMotor(Robot robot, SmartJoystick joystick) {
        this.module = robot.getModule();
        addRequirements(module);
        this.joystick = joystick;

    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        module.moveAngularMotor(joystick.getAxisValue(Axis.LEFT_Y) * 0.8);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        module.stopAngularMotor();

    }

}

