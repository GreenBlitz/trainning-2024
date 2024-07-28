package training.subsystems.Wrist;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.BaseTalonConfiguration;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import utils.GBSubsystem;

import static training.subsystems.Wrist.WristConstants.*;

public class Wrist extends GBSubsystem {
    private static Wrist instance;
    private static Rotation2d targetAngle;

    public static Wrist getInstance() {
        if (instance == null) {
            instance = new Wrist();
        }
        return instance;
    }

    private final TalonSRX motor;
    private final TalonSRXConfiguration motorConfiguration;
    private BaseTalonConfiguration configuration;

    private Wrist() {
        this.motor = new TalonSRX(WRIST_ID);
        this.motorConfiguration = new TalonSRXConfiguration();
        motor.configAllSettings(motorConfiguration);
    }

    @Deprecated // using rotate() and changing manually the constants in the calibration process is advised
    public void setPower(double power) {
        motor.set(TalonSRXControlMode.PercentOutput, power);
        if (Math.abs(power) >= POWER_LIMIT_WRIST) {
            SmartDashboard.putString("motor is trying to spin in power above MAX_POWER_CIM limit", "");
        }
    }

    public void stop() {
        motor.set(TalonSRXControlMode.PercentOutput, 0);
        motorConfiguration.peakCurrentDuration = 0;
        motorConfiguration.continuousCurrentLimit = 0;
        motorConfiguration.peakCurrentLimit = 0;
    }

    public void rotate(WristDirection direction) {
        targetAngle = direction.getValue() == 1 ? WRIST_UPPER_POSITION : WRIST_LOWER_POSITION;
    }

    @Override
    public void subsystemPeriodic() {
        motor.setSelectedSensorPosition(targetAngle.getRotations());
    }

    @Override
    protected String getLogPath() {
        return WRIST_LOG_PATH;
    }
}
