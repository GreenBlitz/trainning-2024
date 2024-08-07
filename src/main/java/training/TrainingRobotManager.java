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
	private Roller roller;
	private Elbow elbow;
	private Wrist wrist;

	public TrainingRobotManager() {
		this.keyboardController = new KeyboardController();
		joystick = new Joystick(0);
	}

	@Override
	public void trainingInit() {
		roller = new Roller();
		elbow = new Elbow();
		wrist = new Wrist();


		this.robot = new Robot();
		keyboardController.A.onTrue(roller.getCommandBuilder().noteOut());
		keyboardController.B.onTrue(elbow.getCommandBuilder().moveElbowUpAndDown());
		keyboardController.C.onTrue(wrist.getCommandBuilder().moveUpWrist());

		wrist.getCommandBuilder().moveUpWrist().schedule();
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
