package training;

import edu.wpi.first.math.geometry.Rotation2d;
import training.commands.MoveAngularByPosition;
import training.commands.MoveElbowByPosition;
import training.commands.MoveLinearMotor;
import training.commands.MoveWristByPosition;
import training.subsystems.Module;
import utils.DefaultRobotManager;
import utils.joysticks.JoystickPorts;
import utils.joysticks.SmartJoystick;

public class TrainingRobotManager extends DefaultRobotManager {

    private Robot robot;
    private SmartJoystick joystick;
    @Override
    public void trainingInit() {
        this.robot = new Robot();
        SetupJoystickControls();
    }

    private void SetupJoystickControls() {
        joystick = new SmartJoystick(JoystickPorts.MAIN);
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
