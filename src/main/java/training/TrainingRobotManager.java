package training;

import com.ctre.phoenix.motorcontrol.IMotorController;
import com.ctre.phoenix6.hardware.TalonFX;
import utils.DefaultRobotManager;

public class TrainingRobotManager extends DefaultRobotManager {

    private Robot robot;
    private TalonFX motor;

    @Override
    public void trainingInit() {
        this.robot = new Robot();
        motor = new TalonFX(0);
    }

    @Override
    public void trainingPeriodic() {
        // add stuff...
    }

    @Override
    public void teleopInit() {
        // schedule your command...
        motor.set(0.5);
    }


    @Override
    public void teleopExit() {
        // cancel your command...
        motor.set(0);
    }

}
