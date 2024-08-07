package training.Wrist.NeoWrist;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import training.Wrist.IWrist;


public class NeoWrist implements IWrist {

	private final TalonSRX motor;

	public NeoWrist() {
		this.motor = new TalonSRX(WristConstants.ID);
		motor.configAllSettings(WristConstants.PID_CONFIG);
	}

	/**
	 * Don't use this in production code. It's here only for debugging etc.
	 */
	@Deprecated
	@Override
	public void setPower(double power) {
		if (Math.abs(power) >= WristConstants.POWER_LIMIT) {
			SmartDashboard.putString("Reverting to max speed 0.9", "");
		}
		motor.set(TalonSRXControlMode.PercentOutput, Math.min(power, WristConstants.POWER_LIMIT));
	}

	@Override
	public void moveToAngle(Rotation2d targetAngle) {
		motor.setSelectedSensorPosition(targetAngle.getRotations());
	}


}
