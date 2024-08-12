package training;

import utils.DefaultRobotManager;

public class TrainingRobotManager extends DefaultRobotManager {

	private final Robot robot;

	public TrainingRobotManager() {
		this.robot = new Robot();
		robot.bindKeyboard();
		System.out.println("logging");
	}

	@Override
	public void trainingInit() {}

	@Override
	public void trainingPeriodic() {
		// add stuff...
	}

	@Override
	public void teleopInit() {
		robot.getElbow().getCommandBuilder().moveUpAndDown().schedule();
		robot.getRoller().getCommandBuilder().noteOut().schedule();
	}


	@Override
	public void teleopExit() {
		// cancel your command...
	}

}
