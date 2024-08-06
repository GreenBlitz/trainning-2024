package training.subsystems.ArmSubsystems.elbowSubsystem.neo;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.geometry.Rotation2d;
import training.RobotConstants;
import training.subsystems.ArmSubsystems.elbowSubsystem.Constants;
import training.subsystems.ArmSubsystems.elbowSubsystem.ElbowInputsAutoLogged;
import training.subsystems.ArmSubsystems.elbowSubsystem.IElbow;


public class NeoElbow implements IElbow {

	private final CANSparkMax motor;

	public NeoElbow() {
		this.motor = new CANSparkMax(Constants.ID, CANSparkLowLevel.MotorType.kBrushless);
		motor.getEncoder().setPositionConversionFactor(Constants.GEAR_RATIO.getDegrees());
		motor.getPIDController().setP(Constants.P_VALUE);
		motor.getPIDController().setI(Constants.I_VALUE);
		motor.getPIDController().setD(Constants.D_VALUE);
		motor.getEncoder().setPosition(Constants.STARTING_POSITION.getDegrees());
	}

	public void setPower(double power) {
		motor.set(power);
	}

	public void setVoltage(double voltage) {
		double appliedVoltage = MathUtil.clamp(voltage, -RobotConstants.MAX_BATTERY_VOLTAGE, RobotConstants.MAX_BATTERY_VOLTAGE);
		motor.setVoltage(appliedVoltage);
	}

	public void goToPosition(Rotation2d position) {
		motor.getPIDController()
			.setReference(
				position.getDegrees(),
				CANSparkBase.ControlType.kPosition,
				0,
				Constants.FEEDFORWARD_CONTROLLER.calculate(getPosition().getRadians(), getVelocity().getRotations())
			);
	}


	@Override
	public void updateInputs(ElbowInputsAutoLogged inputs) {
		inputs.velocity = Rotation2d.fromRotations(motor.getEncoder().getVelocity());
		inputs.current = motor.getOutputCurrent();
		inputs.position = Rotation2d.fromRotations(motor.getEncoder().getPosition());
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
