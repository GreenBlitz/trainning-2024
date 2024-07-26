package training.subsystems.Wrist;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.BaseTalonConfiguration;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
import utils.GBSubsystem;
import utils.WristDirection;

import static training.subsystems.Wrist.WristConstants.*;

public class Wrist extends GBSubsystem {
    private static Wrist instance;
    private final TalonSRX motor = new TalonSRX(WRIST_ID);
    private final TalonSRXConfiguration motorConfiguration = new TalonSRXConfiguration();
    private BaseTalonConfiguration configuration;

    private Wrist() {
    }

    public static Wrist getInstance() {
        if (instance == null) {
            instance = new Wrist();
        }
        return instance;
    }


    /**
     * @param power = the power applied to the motor (-1 to 1)
     * @deprecated use rotate() instead
     */
    @Deprecated // using rotate() and changing manually the constants in the calibration process is advised
    public void setPower(double power) {
        if (Math.abs(power) <= POWER_LIMIT_WRIST) {
            motor.set(TalonSRXControlMode.PercentOutput, power);
        } else {
            throw new RuntimeException("motor is trying to spin in power above MAX_POWER_CIM limit");
        }
    }

    /**
     * stops the wrist from spinning
     */
    public void stop() {
        motor.set(TalonSRXControlMode.PercentOutput, 0);
        motorConfiguration.peakCurrentDuration = 0;
        motorConfiguration.continuousCurrentLimit = 0;
        motorConfiguration.peakCurrentLimit = 0;
    }

    /**
     * rotates the wrist using presets defined in training.subsystems.Roller.Constants until is being stopped
     */
    public void rotate(WristDirection direction) {
        if (PEAK_MAX_CURRENT_WRIST_AMP < CONTINUES_MAX_CURRENT_WRIST_AMP) {
            throw new RuntimeException("Peak Current shall be higher than continues current. pls check your constants");
        } else if (Math.max(PEAK_MAX_CURRENT_WRIST_AMP, CONTINUES_MAX_CURRENT_WRIST_AMP) >= 30) {
            throw new IllegalStateException("Current may be too high. Remove this exception if you SURE your constants and wrist's calibration is correct");
        }
        //* PID should control these settings though currently I'm having troubles with it. Also it can't get info from the motor so idk how PID should operate.
        motorConfiguration.peakCurrentDuration = direction.toInt() * PEAK_DURATION_WRIST_MS;
        motorConfiguration.continuousCurrentLimit = direction.toInt() * CONTINUES_MAX_CURRENT_WRIST_AMP;
        motorConfiguration.peakCurrentLimit = direction.toInt() * PEAK_MAX_CURRENT_WRIST_AMP;
    }

    @Override
    public void subsystemPeriodic() {
        //? no useful docs for the TalonSRXPIDSetConfiguration class are available. pls help
//        motorConfiguration.primaryPID.selectedFeedbackSensor = TalonSRXFeedbackDevice.QuadEncoder.toFeedbackDevice();
        motor.configAllSettings(motorConfiguration);
    }

    @Override
    protected String getLogPath() {
        return WRIST_LOGPATH;
    }
}
