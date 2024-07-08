package training;

import utils.DefaultRobotManager;
import utils.joysticks.SmartJoystick;

public class TrainingRobotManager extends DefaultRobotManager {

    private Robot robot;
    private CommandOfDOOM moveModule;
    private MoveJoystick moveJoystick;
    private SmartJoystick joystick;

    @Override
    public void trainingInit() {
        robot = new Robot();
        moveModule = new CommandOfDOOM(robot);
        joystick = new SmartJoystick(0);
        joystick.A.whileTrue(moveModule);
        moveJoystick = new MoveJoystick(robot, joystick);
        robot.getModule().setDefaultCommand(moveJoystick);
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
