package subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.BaseTalonConfiguration;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static subsystems.Constants.*;

public class WristSubsystem extends SubsystemBase {

    private final TalonSRX motor = new TalonSRX(WRIST_ID);
    private boolean run;
    private BaseTalonConfiguration configuration;
    private TalonSRXConfiguration motorConfiguration = new TalonSRXConfiguration();

    /**
     * @deprecated use rotate() instead
     * @param power = the power applied to the motor (-1 to 1)
     */
    @Deprecated // using rotate() and changing manually the constants in the calibration process is advised
    public void setPower(double power) {
        if (Math.abs(power) <= MAX_POWER_WRIST) {
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
     * rotates the wrist using presets defined in subsystems.Constants until is being stopped
     */
    public void rotate() {
        if (PEAK_MAX_CURRENT_AMP < CONTINUES_MAX_CURRENT_AMP) {
            throw new RuntimeException("peak current shall be higher than continues current. pls check your constants");
        } else if (Math.max(PEAK_MAX_CURRENT_AMP, CONTINUES_MAX_CURRENT_AMP) >= 30) {
            throw new IllegalStateException("Current may be too high. Remove this exception if you SURE your constants and callibration of the wrist is correct");
        }
        //* PID should control these settings though currently I'm having troubles with it. Also it can't get info from the motor so idk how PID should operate.
        motorConfiguration.peakCurrentDuration = PEAK_DURATION_WRIST_MS;
        motorConfiguration.continuousCurrentLimit = CONTINUES_MAX_CURRENT_AMP;
        motorConfiguration.peakCurrentLimit = PEAK_MAX_CURRENT_AMP;
    }

    @Override
    public void periodic() {
        //? no useful docs for the TalonSRXPIDSetConfiguration class are available. pls help
//        motorConfiguration.primaryPID.selectedFeedbackSensor = TalonSRXFeedbackDevice.QuadEncoder.toFeedbackDevice();
        motor.configAllSettings(motorConfiguration);
    }
}
