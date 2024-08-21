package training.commands;

import edu.wpi.first.wpilibj2.command.Command;
import training.ModuleConstants;
import training.Robot;
import training.subsystems.Module;
import utils.joysticks.Axis;
import utils.joysticks.SmartJoystick;

public class MoveLinearMotor extends Command {

    private Module module;
    private SmartJoystick joystick;

    public MoveLinearMotor(Robot robot, SmartJoystick joystick) {
        this.module = robot.getModule();
        this.joystick = joystick;
        addRequirements(module);
    }


    @Override
    public void execute() {
        module.moveLinearMotor(joystick.getAxisValue(Axis.LEFT_X) * ModuleConstants.LINEAR_MOTOR_POWER_MULTIPLIER);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        module.stopLinearMotor();

    }
}
