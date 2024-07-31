package subsystems.wrist;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import utils.GBSubsystem;

public class Wrist extends GBSubsystem {

    private static Wrist instance;
    private static TalonSRX motor;

    private Wrist() {
        motor = new TalonSRX(Constants.WRIST_MOTOR_ID);
    }

    public static Wrist getInstance() {
        if (instance == null) {
            instance = new Wrist();
        }
        return instance;
    }

    public void getToPosition(Rotation2d position) {
        motor.set(Constants.WRIST_PID_CONTROL_MOD, position.getRotations() % Constants.SINGLE_ROTATION * Constants.FULL_CIRCLE_ENCODER_TICKS);
    }

    @Override
    protected String getLogPath() {
        return "";
    }

    @Override
    protected void subsystemPeriodic() {

    }
}
