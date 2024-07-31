package training;

import training.commands.MoveLinearMotorByVoltage;
import utils.DefaultRobotManager;
import utils.joysticks.SmartJoystick;

public class TrainingRobotManager extends DefaultRobotManager {

    private Robot robot;
    private SmartJoystick joystick;

    @Override
    public void trainingInit() {
        robot = new Robot();
        joystick = new SmartJoystick(RobotConstants.ID_OF_FIRST_JOYSTICK);
    }

    @Override
    public void trainingPeriodic() {
        // add stuff...
        joystick.A.whileTrue(new MoveLinearMotorByVoltage(1));
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
