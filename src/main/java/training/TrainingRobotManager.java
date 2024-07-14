package training;

import com.ctre.phoenix6.hardware.TalonFX;
import training.commands.SetAngle;
import utils.DefaultRobotManager;
import utils.KeyboardController;

public class TrainingRobotManager extends DefaultRobotManager {

    private Robot robot;
    private TalonFX motor;
    private KeyboardController keyboardController;
    private double PI = Math.PI;

    @Override
    public void trainingInit() {
        this.robot = new Robot();
        this.keyboardController = new KeyboardController();
        keyboardController.R.onTrue(new SetAngle(0.5*PI));
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
