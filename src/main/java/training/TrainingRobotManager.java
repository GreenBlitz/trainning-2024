package training;

import edu.wpi.first.math.geometry.Rotation2d;
import training.commands.MoveAngularByPosition;
import training.commands.MoveLinearMotor;
import utils.DefaultRobotManager;
import utils.joysticks.JoystickPorts;
import utils.joysticks.SmartJoystick;

public class TrainingRobotManager extends DefaultRobotManager {

    private Robot robot;
    private SmartJoystick joystick;

    @Override
    public void trainingInit() {
        this.robot = new Robot();
        configureBindings();
    }


    public void configureBindings() {
        joystick = new SmartJoystick(JoystickPorts.MAIN);
        joystick.A.whileTrue(new MoveLinearMotor(robot, joystick));
        joystick.B.whileTrue(new MoveAngularByPosition(robot, Rotation2d.fromRotations(2)));
        joystick.X.whileTrue(new MoveAngularByPosition(robot, Rotation2d.fromRotations(1.5)));

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
