package training.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import training.ModuleConstants;
import training.Robot;
import training.subsystems.Module;
import utils.joysticks.Axis;
import utils.joysticks.SmartJoystick;

public class MoveAngularByPosition extends Command {
	private Module module;
	private SmartJoystick joystick;
	private double position;
	public MoveAngularByPosition(Robot robot, SmartJoystick joystick, double position) {
		this.module = robot.getModule();
		addRequirements(module);
		this.joystick = joystick;
		this.position = position;
	}
	
	@Override
	public void initialize() {
	
	}
	
	@Override
	public void execute() {
		module.setAngularMotorByPosition(position);
	}
	
	@Override
	public boolean isFinished() {
		return Math.abs(module.getAngularPosition() - position) <= ModuleConstants.ANGULAR_TOLERANCE;
	}
	
	@Override
	public void end(boolean interrupted) {
		module.stopAngularMotor();
		System.out.println(module.getAngularPosition());
	}
}
