package training;

import utils.SmartJoystick;
import utils.DefaultRobotManager;

public class TrainingRobotManager extends DefaultRobotManager {

	private SmartJoystick joystick;
	private Robot robot;

	public TrainingRobotManager() {
		this.joystick = new SmartJoystick(RobotConstants.JOYSTICK_PORT);
	}

	@Override
	public void trainingInit() {
		this.robot = new Robot();
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
