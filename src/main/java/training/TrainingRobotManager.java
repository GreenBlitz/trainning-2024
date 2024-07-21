
package training;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.utils.hid.SmartJoystick;
import training.commands.GotoAngle;
import utils.DefaultRobotManager;

public class TrainingRobotManager extends DefaultRobotManager {


    private TalonFX motor;
    private SmartJoystick joystick;
    private final double PI = Math.PI;
    private Robot robot;

    @Override
    public void trainingInit() {
        this.robot = new Robot();
        this.joystick = new SmartJoystick(0);
        joystick.A.onTrue(new GotoAngle(0.5 * Math.PI));
        joystick.B.onTrue(new GotoAngle(1.2 * Math.PI));
    }

    @Override
    public void trainingPeriodic() {
        // add stuff...
    }

    @Override
    public void teleopInit() {
        // schedule your command...
        this.motor = new TalonFX(0);
    }


    @Override
    public void teleopExit() {
        motor.set(0);
        // cancel your command...
    }

}
