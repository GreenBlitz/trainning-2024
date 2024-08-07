package training;

import edu.wpi.first.wpilibj.Joystick;
import training.Elbow.Elbow;
import training.Elbow.ElbowCommandBuilder;
import training.Roller.Roller;
import training.Roller.RollerCommandBuilder;
import training.Wrist.Wrist;
import training.Wrist.WristCommandBuilder;
import utils.DefaultRobotManager;
import utils.KeyboardController;

public class TrainingRobotManager extends DefaultRobotManager {

	private final KeyboardController keyboardController;
	private final Joystick joystick;
	private Robot robot;
	private RollerCommandBuilder rollerCommandBuilder;
	private ElbowCommandBuilder elbowCommandBuilder;
	private WristCommandBuilder wristCommandBuilder;

	public TrainingRobotManager() {
		this.keyboardController = new KeyboardController();
		joystick = new Joystick(0);
	}

	@Override
	public void trainingInit() {
		rollerCommandBuilder = new RollerCommandBuilder(new Roller());
		elbowCommandBuilder = new ElbowCommandBuilder(new Elbow());
		wristCommandBuilder = new WristCommandBuilder(new Wrist());


		this.robot = new Robot();
		keyboardController.A.onTrue(rollerCommandBuilder.noteOut());
		keyboardController.B.onTrue(elbowCommandBuilder.moveElbowUpAndDown());
		keyboardController.C.onTrue(wristCommandBuilder.moveUpWrist());

		wristCommandBuilder.moveUpWrist().schedule();
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
