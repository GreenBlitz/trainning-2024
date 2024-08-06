package training.subsystems.ArmSubsystems.elbowSubsystem.simulation;

import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.geometry.Rotation2d;
import training.RobotConstants;
import training.subsystems.ArmSubsystems.elbowSubsystem.ElbowInputsAutoLogged;
import training.subsystems.ArmSubsystems.elbowSubsystem.IElbow;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.simulation.SingleJointedArmSim;
import training.subsystems.ArmSubsystems.elbowSubsystem.Constants;

public class SimulationElbow implements IElbow {

	private final SingleJointedArmSim motor;
	private final PIDController pidController;
	private final ArmFeedforward feedForwardController;

	public SimulationElbow() {
		this.motor = new SingleJointedArmSim(
			DCMotor.getNEO(1),
			Constants.GEAR_RATIO.getDegrees(),
			SingleJointedArmSim.estimateMOI(Constants.ARM_LENGTH, Constants.ARM_MASS_KG),
			Constants.ARM_LENGTH,
			Constants.BACKWARD_ANGLE_LIMIT.getRadians(),
			Constants.FORWARD_ANGLE_LIMIT.getRadians(),
			false,
			Constants.PresetPositions.STARTING.ANGLE.getRadians()
		);

		pidController = Constants.pidController;
		feedForwardController = Constants.FEEDFORWARD_CONTROLLER;
	}

	public void setVoltage(double voltage) {
		double appliedVoltage = MathUtil.clamp(voltage, -RobotConstants.MAX_BATTERY_VOLTAGE, RobotConstants.MAX_BATTERY_VOLTAGE);
		motor.setInputVoltage(appliedVoltage);
	}

	public void setPower(double power) {
		setVoltage(power * RobotConstants.MAX_BATTERY_VOLTAGE);
	}

	public void goToPosition(Rotation2d targetPosition) {
		setVoltage(
			pidController.calculate(getPosition().getDegrees(), targetPosition.getDegrees())
				+ feedForwardController.calculate(getPosition().getDegrees(), targetPosition.getDegrees())
		);
	}

	@Override
	public void updateInputs(ElbowInputsAutoLogged inputs) {
		inputs.velocity = Rotation2d.fromRadians(motor.getVelocityRadPerSec());
		inputs.current = motor.getCurrentDrawAmps();
		inputs.position = Rotation2d.fromRadians(motor.getAngleRads());
	}

	public Rotation2d getPosition() {
		return Rotation2d.fromRadians(motor.getAngleRads());
	}

	public Rotation2d getVelocity() {
		return Rotation2d.fromRotations(motor.getVelocityRadPerSec());
	}

	public boolean isAtTargetAngle(Rotation2d targetAngle, Rotation2d tolerance) {
		return (Math.abs(getPosition().minus(targetAngle).getDegrees()) <= tolerance.getDegrees());
	}

}
