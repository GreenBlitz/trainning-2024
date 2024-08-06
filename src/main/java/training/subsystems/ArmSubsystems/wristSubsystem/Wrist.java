package training.subsystems.ArmSubsystems.wristSubsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.math.geometry.Rotation2d;
import utils.GBSubsystem;

public class Wrist extends GBSubsystem {

	private final TalonSRX motor;
	private final Rotation2d targetPosition;

	public Wrist() {
		this.motor = new TalonSRX(WristConstants.WRIST_ID);
		this.targetPosition = WristConstants.WRIST_STARTING_POSITION;
		motor.configAllSettings(WristConstants.TALON_SRX_CONFIG);
		motor.configSelectedFeedbackSensor(
			FeedbackDevice.CTRE_MagEncoder_Relative,
			WristConstants.PID_SLOT,
			WristConstants.TIMEOUT_FOR_CONFIG_SET
		);
	}

	@Override
	protected String getLogPath() {
		return null;
	}

	@Override
	protected void subsystemPeriodic() {}

	public void goToPosition(Rotation2d targetPosition) {
		motor.selectProfileSlot(WristConstants.PID_SLOT, 0);
		motor.set(ControlMode.Position, targetPosition.getRotations() * WristConstants.MAG_ENCODER_CONVERSION_FACTOR);
	}

	public void setPower(double powerMotor) {
		motor.set(ControlMode.PercentOutput, powerMotor);
	}

	public void stopMotor() {
		this.setPower(0);
	}

	public Rotation2d getPosition() {
		return Rotation2d.fromRotations(motor.getSelectedSensorPosition());
	}

	public Rotation2d getVelocity() {
		return Rotation2d.fromRotations(motor.getSelectedSensorVelocity());
	}

	public boolean isAtTargetAngle(Rotation2d targetAngle, Rotation2d tolerance) {
		return (Math.abs(getPosition().minus(targetAngle).getDegrees()) <= tolerance.getDegrees());
	}

}
