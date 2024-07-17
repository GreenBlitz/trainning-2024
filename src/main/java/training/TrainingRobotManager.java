package training;

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
