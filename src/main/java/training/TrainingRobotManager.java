package training;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.Joystick;
import org.littletonrobotics.junction.Logger;
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
		robot.getElbow().getCommandBuilder().moveUp().schedule();
	}

	@Override
	public void trainingPeriodic() {
		// add stuff...
	}

	@Override
	public void teleopInit() {
		robot.getRoller().getCommandBuilder().rollForward().schedule();
	}


	@Override
	public void teleopExit() {
		// cancel your command...
	}

}
