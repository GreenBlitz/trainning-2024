package training;

import edu.wpi.first.math.geometry.Rotation2d;
import training.subsystems.Arm.Elbow.Elbow;
import utils.DefaultRobotManager;
import utils.KeyboardController;

public class TrainingRobotManager extends DefaultRobotManager {

	private Robot robot;
	private KeyboardController keyboardController;
	private  Elbow elbow;

	@Override
	public void trainingInit() {
		this.robot = new Robot();
		this.keyboardController = new KeyboardController();

		keyboardController.A.onTrue(elbow.getCommmands().moveToPosition(Rotation2d.fromDegrees(0)));
		keyboardController.W.onTrue(elbow.getCommmands().moveToPosition(Rotation2d.fromDegrees(324)));
		keyboardController.D.onTrue(elbow.getCommmands().moveToPosition(Rotation2d.fromDegrees(20)));
		keyboardController.S.onTrue(elbow.getCommmands().moveToPosition(Rotation2d.fromDegrees(80)));
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
