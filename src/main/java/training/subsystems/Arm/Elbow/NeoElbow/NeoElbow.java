package training.subsystems.Arm.Elbow.NeoElbow;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.math.geometry.Rotation2d;
import training.subsystems.Arm.Elbow.ElbowConstants;
import training.subsystems.Arm.Elbow.ElbowInputsAutoLogged;
import training.subsystems.Arm.Elbow.IElbow;

public class NeoElbow implements IElbow {

	private final CANSparkMax motor;

	public NeoElbow() {
		this.motor = new CANSparkMax(NeoElbowConstants.MOTOR_ID, CANSparkLowLevel.MotorType.kBrushless);
		motor.getEncoder().setPositionConversionFactor(ElbowConstants.GEAR_RATIO);
		motor.getPIDController().setP(NeoElbowConstants.P);
		motor.getPIDController().setI(NeoElbowConstants.I);
		motor.getPIDController().setD(NeoElbowConstants.D);
		motor.getEncoder().setPosition(ElbowConstants.PresetPositions.STARTING.ANGLE.getDegrees());
	}


	@Override
	public void moveToPosition(Rotation2d position) {
		motor.getPIDController()
			.setReference(
				position.getDegrees(),
				CANSparkBase.ControlType.kPosition,
				NeoElbowConstants.PID_SLOT,
				NeoElbowConstants.ARM_FEEDFORWARD.calculate(getPosition().getRadians(), getVelocity().getRotations())
			);
	}

	@Override
	public void stayAtPosition() {
		moveToPosition(getPosition());
	}

	@Override
	public Rotation2d getPosition() {
		return Rotation2d.fromRotations(motor.getEncoder().getPosition());
	}

	@Override
	public void updateInputs(ElbowInputsAutoLogged inputs) {
		inputs.velocity = this.getVelocity().getRotations();
		inputs.current = this.motor.getOutputCurrent();
		inputs.position = this.getPosition();
		inputs.voltage = motor.getBusVoltage() * motor.getAppliedOutput();
		inputs.positionReference = Rotation2d.fromDegrees(55);
	}

	public Rotation2d getVelocity() {
		return Rotation2d.fromRotations(motor.getEncoder().getVelocity());
	}

	@Override
	public void setPower(double power) {
		motor.set(power);
	}

}
