package training;

import edu.wpi.first.wpilibj.Joystick;
import training.Elbow.ElbowCommandBuilder;
import training.Roller.RollerCommandBuilder;
import training.Wrist.WristCommandBuilder;
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
		keyboardController.A.onTrue(new RollerCommandBuilder().noteOut());
		keyboardController.B.onTrue(new ElbowCommandBuilder().liftElbow());
		keyboardController.C.onTrue(new WristCommandBuilder().moveUpWrist());
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
