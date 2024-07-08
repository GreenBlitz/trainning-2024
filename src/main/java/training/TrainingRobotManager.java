package training;

import com.ctre.phoenix.motorcontrol.IMotorController;
import com.ctre.phoenix6.hardware.TalonFX;
import utils.DefaultRobotManager;

public class TrainingRobotManager extends DefaultRobotManager {

    private Robot robot;

    @Override
    public void trainingInit() {
        this.robot = new Robot();
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
