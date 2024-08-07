package training;

import training.Elbow.Elbow;
import training.Roller.Roller;
import training.Wrist.Wrist;
import utils.KeyboardController;

public class Robot {

	private final Roller roller;
	private final Elbow elbow;
	private final Wrist wrist;
	private final KeyboardController keyboardController;

	public Robot() {
		this.keyboardController = new KeyboardController();
		this.roller = new Roller();
		this.elbow = new Elbow();
		this.wrist = new Wrist();
	}

	public static final RobotType ROBOT_TYPE = RobotType.SIMULATION;

	public Roller getRoller() {
		return roller;
	}

	public Elbow getElbow() {
		return elbow;
	}

	public Wrist getWrist() {
		return wrist;
	}

	public void bindKeyboard() {
		keyboardController.A.onTrue(roller.getCommandBuilder().noteOut());
		keyboardController.B.onTrue(elbow.getCommandBuilder().moveUpAndDown());
		keyboardController.C.onTrue(wrist.getCommandBuilder().moveUp());
	}

}
