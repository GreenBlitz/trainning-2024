package training.subsystems.ArmSubsystems.elbow.neo;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.geometry.Rotation2d;
import training.GlobalConstants;
import training.subsystems.ArmSubsystems.elbow.ElbowConstants;
import training.subsystems.ArmSubsystems.elbow.ElbowInputsAutoLogged;
import training.subsystems.ArmSubsystems.elbow.IElbow;


public class Neo implements IElbow {

	private final CANSparkMax motor;

	public Neo() {
		this.motor = new CANSparkMax(NeoConstants.ID, CANSparkLowLevel.MotorType.kBrushless);
		motor.getEncoder().setPositionConversionFactor(NeoConstants.GEAR_RATIO.getRotations());
		motor.getEncoder().setVelocityConversionFactor(NeoConstants.GEAR_RATIO.getRotations());

		motor.setSoftLimit(CANSparkBase.SoftLimitDirection.kForward, (float) ElbowConstants.FORWARD_ANGLE_LIMIT.getRotations());
		motor.enableSoftLimit(CANSparkBase.SoftLimitDirection.kForward, true);

		motor.setSoftLimit(CANSparkBase.SoftLimitDirection.kReverse, (float) ElbowConstants.BACKWARD_ANGLE_LIMIT.getRotations());
		motor.enableSoftLimit(CANSparkBase.SoftLimitDirection.kReverse, true);

		motor.getPIDController().setP(NeoConstants.P_VALUE);
		motor.getPIDController().setI(NeoConstants.I_VALUE);
		motor.getPIDController().setD(NeoConstants.D_VALUE);
		motor.getEncoder().setPosition(ElbowConstants.STARTING_POSITION.getRotations());
	}

	public void setPower(double power) {
		motor.set(power);
	}

	public void setVoltage(double voltage) {
		double appliedVoltage = MathUtil
			.clamp(voltage, -GlobalConstants.MAX_BATTERY_VOLTAGE, GlobalConstants.MAX_BATTERY_VOLTAGE);
		motor.setVoltage(appliedVoltage);
	}

	public void goToPosition(Rotation2d position) {
		motor.getPIDController()
			.setReference(
				position.getRotations(),
				CANSparkBase.ControlType.kPosition,
				0,
				NeoConstants.FEEDFORWARD_CONTROLLER.calculate(getPosition().getRadians(), getVelocity().getRotations())
			);
	}

	@Override
	public void stayAtPosition() {
		setVoltage(NeoConstants.FEEDFORWARD_CONTROLLER.calculate(getPosition().getRadians(), getVelocity().getRadians()));
	}

	@Override
	public void updateInputs(ElbowInputsAutoLogged inputs) {
		inputs.position = Rotation2d.fromRotations(motor.getEncoder().getPosition());
		inputs.velocity = Rotation2d.fromRotations(motor.getEncoder().getVelocity());
		inputs.current = motor.getOutputCurrent();
		inputs.voltage = motor.getBusVoltage() * motor.getAppliedOutput();
	}


	public Rotation2d getPosition() {
		return Rotation2d.fromRotations(motor.getEncoder().getPosition());
	}

	public Rotation2d getVelocity() {
		return Rotation2d.fromRotations(motor.getEncoder().getVelocity());
	}

	public boolean isAtTargetAngle(Rotation2d targetAngle, Rotation2d tolerance) {
		return (Math.abs(getPosition().minus(targetAngle).getDegrees()) <= tolerance.getDegrees());
	}

}
