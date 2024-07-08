package training;

import com.ctre.phoenix.motorcontrol.IMotorController;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.Command;
import utils.DefaultRobotManager;
import utils.joysticks.SmartJoystick;

public class TrainingRobotManager extends DefaultRobotManager {

    private Robot robot;
    private CommandOfDOOM com;

    @Override
    public void trainingInit() {
        this.robot = new Robot();
        com = new CommandOfDOOM(robot);
        SmartJoystick joystick = new SmartJoystick(0);
        joystick.A.whileTrue(com);
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
