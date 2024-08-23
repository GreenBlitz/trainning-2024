package training;

import edu.wpi.first.math.geometry.Rotation2d;
import training.commands.elbow.MoveElbowToAngle;
import training.commands.wrist.MoveWristToAngle;
import training.subsystems.RobotArm.elbow.Elbow;
import utils.DefaultRobotManager;
import utils.KeyboardController;

public class TrainingRobotManager extends DefaultRobotManager {

	private Robot robot;

	@Override
	public void trainingInit() {
		this.robot = new Robot();
	}

	@Override
	public void trainingPeriodic() {
		// add stuff...
	}

	@Override
	public void teleopInit() {
		// schedule your command...
		KeyboardController keyboardController = new KeyboardController();
		KeyboardController keyboardController1 = new KeyboardController();
		KeyboardController keyboardController2 = new KeyboardController();
		KeyboardController keyboardController3 = new KeyboardController();

		keyboardController1.A.whileTrue(new MoveElbowToAngle(Rotation2d.fromDegrees(30), Elbow.getInstance()));
	}


	@Override
	public void teleopExit() {
		// cancel your command...
	}

}
