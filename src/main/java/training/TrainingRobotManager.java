package training;

import edu.wpi.first.math.geometry.Rotation2d;
import training.commands.ArmCommands.elbowCommands.ElbowStayInPlace;
import training.commands.ArmCommands.elbowCommands.MoveElbow;
import training.commands.ArmCommands.wristCommands.MoveWrist;
import training.commands.ArmCommands.rollerCommands.RollClockwise;
import training.commands.ArmCommands.rollerCommands.RollCounterClockwise;
import training.commands.ArmCommands.wristCommands.StopWrist;
import training.subsystems.ArmSubsystems.elbow.Elbow;
import training.subsystems.ArmSubsystems.elbow.ElbowConstants;
import training.subsystems.ArmSubsystems.wrist.Wrist;
import training.subsystems.ArmSubsystems.wrist.WristConstants;
import utils.DefaultRobotManager;
import utils.joysticks.SmartJoystick;

public class TrainingRobotManager extends DefaultRobotManager {

	private Robot robot;
	private SmartJoystick smartJoystick;

	public void configJoystick(Robot robot) {
		this.smartJoystick = new SmartJoystick(GlobalConstants.ID_OF_SMART_JOYSTICK);

		smartJoystick.B.onTrue(new MoveElbow(ElbowConstants.CLIMBING_POSITION, robot.getElbow()));
		smartJoystick.A.onTrue(new MoveElbow(ElbowConstants.STARTING_POSITION, robot.getElbow()));

		smartJoystick.Y.onTrue(new MoveWrist(WristConstants.CLIMBING_POSITION, robot.getWrist()));
		smartJoystick.X.onTrue(new MoveElbow(Rotation2d.fromDegrees(20), robot.getElbow()));

		smartJoystick.R1.whileTrue(new RollClockwise(robot.getRoller()));
		smartJoystick.R2.whileTrue(new RollCounterClockwise(robot.getRoller()));
	}

	public void configDefaultCommands(Elbow elbow, Wrist wrist) {
		elbow.setDefaultCommand(new ElbowStayInPlace(robot.getElbow()));
		wrist.setDefaultCommand(new StopWrist(robot.getWrist()));
	}

	@Override
	public void trainingInit() {
		this.robot = new Robot();
		configJoystick(robot);
		configDefaultCommands(robot.getElbow(), robot.getWrist());
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
