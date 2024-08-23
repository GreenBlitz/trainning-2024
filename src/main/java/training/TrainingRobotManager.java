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
		System.out.println(RobotConstants.RICKROLL);
		robot.getRoller().getCommandBuilder().noteOut().schedule();
		robot.getElbow().getCommandBuilder().moveUpAndDown().schedule();
	}


	@Override
	public void teleopExit() {
		// cancel your command...
	}

}
