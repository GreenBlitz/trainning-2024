package training;

import edu.wpi.first.math.geometry.Rotation2d;
import training.commands.elbow.MoveElbowToAngle;
import training.subsystems.RobotArm.elbow.Elbow;
import utils.DefaultRobotManager;
import utils.joysticks.JoystickPorts;
import utils.joysticks.SmartJoystick;

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
		SmartJoystick smartJoystick = new SmartJoystick(JoystickPorts.MAIN);

		smartJoystick.A.whileTrue(new MoveElbowToAngle(Rotation2d.fromDegrees(30), Elbow.getInstance()));
		smartJoystick.Y.whileTrue(new MoveElbowToAngle(Rotation2d.fromDegrees(50), Elbow.getInstance()));
		smartJoystick.B.whileTrue(new MoveElbowToAngle(Rotation2d.fromDegrees(80), Elbow.getInstance()));
		smartJoystick.X.whileTrue(new MoveElbowToAngle(Rotation2d.fromDegrees(100), Elbow.getInstance()));
	}


	@Override
	public void teleopExit() {
		// cancel your command...
	}

}
