package training;

import training.subsystems.elbow.RobotTypes;
import utils.DefaultRobotManager;

public class TrainingRobotManager extends DefaultRobotManager {

	private Robot robot;

	public static final RobotTypes ROBOT_TYPE= RobotTypes.SIMULATION;

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
