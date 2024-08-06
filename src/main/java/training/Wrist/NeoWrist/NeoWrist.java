package training.Wrist.NeoWrist;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.BaseTalonConfiguration;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import training.Wrist.IWrist;


public class NeoWrist implements IWrist {
    private final TalonSRX motor;
    private BaseTalonConfiguration configuration;
    private boolean inTestingMode;

    public NeoWrist() {
        this.motor = new TalonSRX(WristConstnats.WRIST_ID);
        this.inTestingMode = false;
        motor.configAllSettings(WristConstnats.WRIST_PID_CONFIG);
    }

    /** Don't use this in production code. It's here only for debugging etc.
     */
    @Deprecated
    @Override
    public void setPower(double power) {
        inTestingMode = true;
        if (Math.abs(power) >= WristConstnats.POWER_LIMIT_WRIST) {
            SmartDashboard.putString("Reverting to max speed 0.9", "");
        }
        motor.set(TalonSRXControlMode.PercentOutput, Math.min(power, WristConstnats.POWER_LIMIT_WRIST));
    }

    @Override
    public void updateAngle(Rotation2d targetAngle) {
        if (!inTestingMode) {
            motor.setSelectedSensorPosition(targetAngle.getRotations());
        }
    }


}
