package training.subsystems.ArmSubsystems.elbowSubsystem.neoElbow;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.geometry.Rotation2d;
import training.RobotConstants;
import training.subsystems.ArmSubsystems.elbowSubsystem.ElbowConstants;
import training.subsystems.ArmSubsystems.elbowSubsystem.ElbowInputsAutoLogged;
import training.subsystems.ArmSubsystems.elbowSubsystem.IElbow;
import training.subsystems.ArmSubsystems.elbowSubsystem.ElbowConstants;


public class NeoElbow implements IElbow {

	private final CANSparkMax motor;

	private static NeoElbow instance;
	private double appliedVoltage;


	private NeoElbow() {
		this.motor = new CANSparkMax(ElbowConstants.ELBOW_ID, CANSparkLowLevel.MotorType.kBrushless);
		motor.getEncoder().setPositionConversionFactor(ElbowConstants.ELBOW_GEAR_RATIO.getDegrees());
		motor.getPIDController().setP(ElbowConstants.ELBOW_P_VALUE);
		motor.getPIDController().setI(ElbowConstants.ELBOW_I_VALUE);
		motor.getPIDController().setD(ElbowConstants.ELBOW_D_VALUE);
		motor.getEncoder().setPosition(ElbowConstants.ELBOW_STARTING_POSITION.getDegrees());
	}

	public static NeoElbow getInstance() {
		if (instance == null) {
			instance = new NeoElbow();
		}
		return instance;
	}

	public void setPower(double power) {
		motor.set(power);
	}

	public void setVoltage(double voltage) {
		appliedVoltage = MathUtil.clamp(voltage, -RobotConstants.MAX_MOTOR_VOLTAGE, RobotConstants.MAX_MOTOR_VOLTAGE);
		motor.setVoltage(appliedVoltage);
	}

	public void goToPosition(Rotation2d position) {
		motor.getPIDController()
			.setReference(
				position.getDegrees(),
				CANSparkBase.ControlType.kPosition,
				0,
				ElbowConstants.FEEDFORWARD_CONTROLER.calculate(getPosition().getRadians(), getVelocity())
			);
	}

	public void stayAtPosition() {
		goToPosition(getPosition());
	}

	@Override
	public boolean isAtTargetPosition(Rotation2d targetAngle, Rotation2d tolerance) {
		return Math.abs(getPosition().minus(targetAngle).getDegrees()) <= tolerance.getDegrees();
	}

	@Override
	public void updateInputs(ElbowInputsAutoLogged inputs) {
		inputs.motorVelocity = Rotation2d.fromRotations(motor.getEncoder().getVelocity());
		inputs.motorCurrent = motor.getOutputCurrent();
	}

	public Rotation2d getPosition() {
		return Rotation2d.fromRotations(motor.getEncoder().getPosition());
	}

	public double getVelocity() {
		return motor.getEncoder().getVelocity();
	}

	public boolean isAtTargetAngle(Rotation2d targetAngle, Rotation2d tolerance) {
		return (Math.abs(getPosition().minus(targetAngle).getDegrees()) <= tolerance.getDegrees());
	}

}
