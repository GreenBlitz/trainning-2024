package training;

import edu.wpi.first.math.geometry.Rotation2d;
import training.commands.GoToPosition;
import training.commands.MoveModuleMotor;
import training.commands.MoveMotorWithJoystick;
import utils.DefaultRobotManager;
import utils.joysticks.SmartJoystick;

public class TrainingRobotManager extends DefaultRobotManager {

    private Robot robot;
    private MoveModuleMotor moveModule;
    private MoveMotorWithJoystick moveMotorWithJoystick;
    private SmartJoystick joystick;
    private GoToPosition goToPosition;

    @Override
    public void trainingInit() {
        robot = new Robot();
        moveModule = new MoveModuleMotor(robot.getModule());
        joystick = new SmartJoystick(RobotConstants.ID_OF_FIRST_JOYSTICK);
        joystick.A.whileTrue(moveModule);
        moveMotorWithJoystick = new MoveMotorWithJoystick(robot, joystick);
        goToPosition = new GoToPosition(robot, Rotation2d.fromDegrees(200));
        robot.getModule().setDefaultCommand(moveMotorWithJoystick);
        joystick.B.onTrue(goToPosition);
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
