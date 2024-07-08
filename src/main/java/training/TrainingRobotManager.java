package training;

import com.ctre.phoenix6.hardware.TalonFX;
import utils.DefaultRobotManager;

public class TrainingRobotManager extends DefaultRobotManager {

    private Robot robot;
    private TalonFX motor;
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
        this.motor = new TalonFX(0);
        motor.set(0.9);
    }


    @Override
    public void teleopExit() {
        motor.set(0);
        // cancel your command...
    }

}
