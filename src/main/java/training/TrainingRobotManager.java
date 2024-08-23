package training;

import edu.wpi.first.math.geometry.Rotation2d;
import training.commands.elbow.MoveElbowToAngle;
import training.subsystems.elbow.RobotTypes;
import utils.DefaultRobotManager;
import utils.joysticks.JoystickPorts;
import utils.joysticks.SmartJoystick;

public class TrainingRobotManager extends DefaultRobotManager {

	private Robot robot;

	private SmartJoystick smartJoystick;

	public static final RobotTypes ROBOT_TYPE= RobotTypes.SIMULATION;

	@Override
	public void trainingInit() {
		this.robot = new Robot();
		this.smartJoystick = new SmartJoystick(JoystickPorts.MAIN);
		smartJoystick.A.whileTrue(new MoveElbowToAngle(Rotation2d.fromDegrees(45)));
		smartJoystick.B.whileTrue(new MoveElbowToAngle(Rotation2d.fromDegrees(60)));

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
