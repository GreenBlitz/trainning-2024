package training.Wrist;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.BaseTalonConfiguration;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import utils.GBSubsystem;

import static training.Wrist.WristConstants.POWER_LIMIT_WRIST;
import static training.Wrist.WristConstants.WRIST_ID;
import static training.Wrist.WristConstants.WRIST_UPPER_POSITION;
import static training.Wrist.WristConstants.WRIST_LOWER_POSITION;
import static training.Wrist.WristConstants.WRIST_LOG_PATH;
import static training.Wrist.WristConstants.WRIST_PID_CONFIG;

public class NeoWrist implements IWrist {
    private final TalonSRX motor;
    private BaseTalonConfiguration configuration;
    private boolean inTestingMode;

    public NeoWrist() {
        this.motor = new TalonSRX(WRIST_ID);
        this.inTestingMode = false;
        motor.configAllSettings(WRIST_PID_CONFIG);
    }

    /** Don't use this in production code. It's here only for debugging etc.
     */
    @Deprecated
    @Override
    public void setPowerTestingOnly(double power) {
        inTestingMode = true;
        if (Math.abs(power) >= POWER_LIMIT_WRIST) {
            SmartDashboard.putString("motor is trying to spin in power above MAX_POWER_CIM limit. Reverting to 0.9", "");
        }
        motor.set(TalonSRXControlMode.PercentOutput, Math.min(power, 0.9));
    }

    @Override
    public void updateAngle(Rotation2d targetAngle) {
        if (!inTestingMode) {
            motor.setSelectedSensorPosition(targetAngle.getRotations());
        }
    }

}
