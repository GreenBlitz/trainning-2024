package training;

import edu.wpi.first.wpilibj2.command.InstantCommand;
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
		this.joystick = new SmartJoystick(RobotConstants.JOYSTICK_PORT);
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
		// ! Doesn't work
		keyboardController.A.onTrue(roller.getCommandBuilder().rollForward());
		keyboardController.B.onTrue(elbow.getCommandBuilder().moveUpAndDown());
		keyboardController.C.onTrue(wrist.getCommandBuilder().moveUp());
		keyboardController.D.onTrue(new InstantCommand(() -> System.out.println("D was pressed")));
		joystick.A.onTrue(new InstantCommand(() -> System.out.println("joystick A was pressed")));
		joystick.L1.onTrue(new InstantCommand(() -> System.out.println("joystick L1 was pressed")));
		joystick.POV_DOWN.onTrue(new InstantCommand(() -> System.out.println("joystick povdown was pressed")));
		joystick.A.onTrue(roller.getCommandBuilder().rollForward());
		joystick.B.onTrue(roller.getCommandBuilder().noteOut());
	}

}
