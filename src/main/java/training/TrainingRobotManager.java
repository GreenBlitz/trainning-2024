package training;

import edu.wpi.first.wpilibj.Joystick;
import utils.DefaultRobotManager;
import utils.KeyboardController;

public class TrainingRobotManager extends DefaultRobotManager {

	private final KeyboardController keyboardController;
	private final Joystick joystick;
	private final Robot robot;

	public TrainingRobotManager() {
		this.robot = new Robot();
		this.keyboardController = new KeyboardController();
		joystick = new Joystick(0);
	}

	@Override
	public void trainingInit() {
		robot.bindKeyboard();
	}

	@Override
	public void trainingPeriodic() {
		// add stuff...
	}

	@Override
	public void teleopInit() {
		robot.getElbow().getCommandBuilder().moveUpAndDown().schedule();
	}


	@Override
	public void teleopExit() {
		// cancel your command...
	}

}
