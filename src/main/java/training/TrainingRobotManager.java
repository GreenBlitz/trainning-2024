package training;

import training.commands.MoveAngularByPosition;
import training.commands.MoveLinearMotor;
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
        joystick = new SmartJoystick(JoystickPorts.MAIN);
        joystick.A.whileTrue(new MoveLinearMotor(robot,joystick));
        joystick.B.whileTrue(new MoveAngularByPosition(robot, joystick, 2));
        joystick.X.whileTrue(new MoveAngularByPosition(robot, joystick, 1.5));
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
