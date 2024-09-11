package subsystems.wrist.talonWrist;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.math.geometry.Rotation2d;
import subsystems.wrist.IWrist;
import subsystems.wrist.WristInputsAutoLogged;

public class TalonWrist implements IWrist {

	private static TalonSRX motor;

	public TalonWrist() {
		this.motor = new TalonSRX(TalonWristConstants.MOTOR_ID);
	}


	public void goToPosition(Rotation2d position) {
		motor.set(
			TalonWristConstants.PID_CONTROL_MODE,
			position.getRotations() % 1 * TalonWristConstants.FULL_CIRCLE_ENCODER_TICKS
		);
	}

	@Override
	public void setPower(double power) {
		motor.set(TalonSRXControlMode.PercentOutput, power);
	}

	@Override
	public void updateInputs(WristInputsAutoLogged inputs) {
		inputs.angle = Rotation2d.fromRotations(motor.getSelectedSensorPosition());
	}

}
