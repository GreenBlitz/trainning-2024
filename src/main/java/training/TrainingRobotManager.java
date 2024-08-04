package training;

import org.littletonrobotics.junction.AutoLog;
import training.commands.MoveAngularMotorByVoltage;
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
        joystick.A.whileTrue(new MoveAngularMotorByVoltage(1));
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
