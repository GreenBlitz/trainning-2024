package training;

import edu.wpi.first.math.geometry.Rotation2d;
import training.commands.MoveWristByPosition;
import utils.DefaultRobotManager;
import utils.joysticks.JoystickPorts;
import utils.joysticks.SmartJoystick;

public class TrainingRobotManager extends DefaultRobotManager {

    private Robot robot;
    @Override
    public void trainingInit() {
        robot = new Robot();
        setupJoystickControls();
    }

    private void setupJoystickControls() {
        SmartJoystick joystick = new SmartJoystick(JoystickPorts.MAIN);
        joystick.A.onTrue(new MoveWristByPosition(robot, Rotation2d.fromDegrees(90)));
        joystick.B.onTrue(new MoveWristByPosition(robot, Rotation2d.fromDegrees(180)));
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
    }

}
