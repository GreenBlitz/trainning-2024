package training.subsystems.ArmSubsystems.elbow.neoElbow;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.geometry.Rotation2d;
import training.GlobalConstants;
import training.subsystems.ArmSubsystems.elbow.ElbowConstants;
import training.subsystems.ArmSubsystems.elbow.ElbowInputsAutoLogged;
import training.subsystems.ArmSubsystems.elbow.IElbow;


public class NeoElbow implements IElbow {

	private final CANSparkMax motor;

	public NeoElbow() {
		this.motor = new CANSparkMax(NeoElbowConstants.ID, CANSparkLowLevel.MotorType.kBrushless);
		motorConfig();
	}

	private void motorConfig() {
		motor.getEncoder().setPositionConversionFactor(NeoElbowConstants.GEAR_RATIO.getRotations());
		motor.getEncoder().setVelocityConversionFactor(NeoElbowConstants.GEAR_RATIO.getRotations());

		motor.setSoftLimit(CANSparkBase.SoftLimitDirection.kForward, (float) ElbowConstants.FORWARD_ANGLE_LIMIT.getRotations());
		motor.enableSoftLimit(CANSparkBase.SoftLimitDirection.kForward, true);

		motor.setSoftLimit(CANSparkBase.SoftLimitDirection.kReverse, (float) ElbowConstants.BACKWARD_ANGLE_LIMIT.getRotations());
		motor.enableSoftLimit(CANSparkBase.SoftLimitDirection.kReverse, true);

		motor.getPIDController().setP(NeoElbowConstants.KP);
		motor.getPIDController().setI(NeoElbowConstants.KI);
		motor.getPIDController().setD(NeoElbowConstants.KD);
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
				NeoElbowConstants.ARM_FEEDFORWARD_CONTROLLER.calculate(getPosition().getRadians(), getVelocity().getRotations())
			);
	}

	@Override
	public void stayInPosition() {
		setVoltage(
			NeoElbowConstants.ARM_FEEDFORWARD_CONTROLLER.calculate(getPosition().getRadians(), getVelocity().getRotations())
		);
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

}
