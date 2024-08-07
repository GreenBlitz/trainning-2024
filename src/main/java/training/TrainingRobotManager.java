package training;

import edu.wpi.first.wpilibj.Joystick;
import training.Elbow.Elbow;
import training.Roller.Roller;
import training.Wrist.Wrist;
import utils.DefaultRobotManager;
import utils.KeyboardController;

public class TrainingRobotManager extends DefaultRobotManager {

	private final KeyboardController keyboardController;
	private final Joystick joystick;
	private Robot robot;

	public TrainingRobotManager() {
		this.keyboardController = new KeyboardController();
		joystick = new Joystick(0);
	}

	@Override
	public void trainingInit() {
		this.robot = new Robot();
		robot.bindKeyboard();
		robot.getElbow().getCommandBuilder().moveUp().schedule();
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
