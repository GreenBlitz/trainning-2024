package training;

import training.Elbow.Elbow;
import training.Roller.Roller;
import training.Wrist.Wrist;
import utils.KeyboardController;
import utils.joystick.SmartJoystick;

public class Robot {

	private final Roller roller;
	private final Elbow elbow;
	private final Wrist wrist;
	private final KeyboardController keyboardController;
	private final SmartJoystick joystick;

	public Robot() {
		this.keyboardController = new KeyboardController();
		this.joystick = new SmartJoystick(RobotConstants.joystickPort);
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
//		keyboardController.A.whileTrue(roller.getCommandBuilder().rollForward());
//		keyboardController.B.whileTrue(elbow.getCommandBuilder().moveUpAndDown());
//		keyboardController.C.whileTrue(wrist.getCommandBuilder().moveUp());
		joystick.A.onTrue(roller.getCommandBuilder().rollForward());
		joystick.B.onTrue(roller.getCommandBuilder().noteOut());
	}

}
