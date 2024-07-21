package subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRXPIDSetConfiguration;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static subsystems.Constants.*;

public class Wrist extends SubsystemBase {

    private final TalonSRX motor = new TalonSRX(WRIST_ID);
    private final Rotation2d angle = DEFAULT_POSITION;
    private boolean run;

    public void setPower(double power) {
        if (Math.abs(power) <= MAX_POWER_CIM) {
            motor.set(TalonSRXControlMode.Position, power);
        }
    }

    public void stop() {
        SmartDashboard.putNumber("emergency stop at value (deg) ", angle.getDegrees());

    }

    @Override
    public void periodic() {
        if (run) {
            motor.getPIDConfigs(new TalonSRXPIDSetConfiguration()); // what should I do here
        }

    }
}
