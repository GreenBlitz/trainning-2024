package subsystems.wrist;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.math.geometry.Rotation2d;
import utils.GBSubsystem;

public class Wrist extends GBSubsystem {

    private static Wrist instance;
    private static TalonSRX motor;

    private Wrist() {
        motor = new TalonSRX(WristConstants.WRIST_MOTOR_ID);
    }

    public static Wrist getInstance() {
        if (instance == null) {
            instance = new Wrist();
        }
        return instance;
    }

    public void GoToPosition(Rotation2d position) {
        motor.set(WristConstants.WRIST_PID_CONTROL_MODE,
                position.getRotations() % WristConstants.SINGLE_ROTATION * WristConstants.FULL_CIRCLE_ENCODER_TICKS);
    }

    @Override
    protected String getLogPath() {
        return "";
    }

    @Override
    protected void subsystemPeriodic() {

    }
}
