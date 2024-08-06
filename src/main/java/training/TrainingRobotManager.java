package training;

import training.commands.ArmCommands.elbowCommands.ElbowDefaultCommand;
import training.commands.ArmCommands.elbowCommands.MoveElbow;
import training.commands.ArmCommands.wristCommands.MoveWrist;
import training.commands.ArmCommands.rollerCommands.RollClockwise;
import training.commands.ArmCommands.rollerCommands.RollCounterClockwise;
import training.commands.ArmCommands.wristCommands.WristDefaultCommand;
import training.subsystems.ArmSubsystems.elbowSubsystem.Constants;
import training.subsystems.ArmSubsystems.wristSubsystem.WristConstants;
import utils.DefaultRobotManager;
import utils.joysticks.SmartJoystick;

public class TrainingRobotManager extends DefaultRobotManager {

	private Robot robot;
	private SmartJoystick smartJoystick;

	@Override
	public void trainingInit() {
		this.robot = new Robot();
		this.smartJoystick = new SmartJoystick(RobotConstants.ID_OF_SMART_JOYSTICK);

		smartJoystick.B.onTrue(new MoveElbow(Constants.CLIMBING_POSITION, robot.getElbow()));
		smartJoystick.A.onTrue(new MoveElbow(Constants.CLIMBING_POSITION, robot.getElbow()));

		smartJoystick.Y.onTrue(new MoveWrist(WristConstants.WRIST_CLIMBING_POSITION, robot.getWrist()));
		smartJoystick.X.onTrue(new MoveWrist(WristConstants.WRIST_STARTING_POSITION, robot.getWrist()));

		smartJoystick.R1.whileTrue(new RollClockwise(robot.getRoller()));
		smartJoystick.R2.whileTrue(new RollCounterClockwise(robot.getRoller()));

		robot.getElbow().setDefaultCommand(new ElbowDefaultCommand(robot.getElbow()));
		robot.getWrist().setDefaultCommand(new WristDefaultCommand(robot.getWrist()));
	}

	@Override
	public void trainingPeriodic() {
		// add stuff...
	}


	@Override
	public void teleopInit() {
		// schedule your command...
	}


	@Override
	public void teleopExit() {
		// cancel your command...
	}

}
