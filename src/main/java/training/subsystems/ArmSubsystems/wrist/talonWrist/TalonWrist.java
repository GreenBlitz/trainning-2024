package training.subsystems.ArmSubsystems.wrist.talonWrist;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.math.geometry.Rotation2d;
import training.GlobalConstants;
import training.subsystems.ArmSubsystems.wrist.IWrist;
import training.subsystems.ArmSubsystems.wrist.WristInputsAutoLogged;

public class TalonWrist implements IWrist {

	private final TalonSRX motor;

	public TalonWrist() {
		this.motor = new TalonSRX(TalonWristConstants.ID);
		motor.configAllSettings(TalonWristConstants.TALON_SRX_CONFIG);
		motor.get
	}

	@Override
	public void goToPosition(Rotation2d targetPosition) {
		setVoltage(
			TalonWristConstants.PID_CONTROLLER.calculate(motor.getSelectedSensorPosition(), targetPosition.getRotations())
		);
	}

	@Override
	public void setVoltage(double voltage) {
		motor.set(ControlMode.PercentOutput, voltage / GlobalConstants.DEFAULT_BATTERY_VOLTAGE);
	}

	@Override
	public void setPower(double power) {
		motor.set(ControlMode.PercentOutput, power);
	}

	public Rotation2d getPosition(){
		return  Rotation2d.fromRotations(motor.getSelectedSensorPosition()*TalonWristConstants.MAG_ENCODER_CONVERSION_FACTOR);
	}

	@Override
	public void updateInputs(WristInputsAutoLogged inputs) {
		inputs.position = getPosition();
		inputs.velocity = Rotation2d.fromRotations(motor.getSelectedSensorVelocity());
		inputs.voltage = motor.getMotorOutputVoltage();
		;
	}

}
