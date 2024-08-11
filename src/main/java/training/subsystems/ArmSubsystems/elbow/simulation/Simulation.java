package training.subsystems.ArmSubsystems.elbow.simulation;

import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.geometry.Rotation2d;
import training.GlobalConstants;
import training.subsystems.ArmSubsystems.elbow.ElbowInputsAutoLogged;
import training.subsystems.ArmSubsystems.elbow.IElbow;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.simulation.SingleJointedArmSim;
import training.subsystems.ArmSubsystems.elbow.ElbowConstants;

public class Simulation implements IElbow {

	private final SingleJointedArmSim motor;
	private final PIDController pidController;
	private final ArmFeedforward feedForwardController;

	public Simulation() {
		this.motor = new SingleJointedArmSim(
			DCMotor.getNEO(1),
			ElbowConstants.GEAR_RATIO.getDegrees(),
			SingleJointedArmSim.estimateMOI(ElbowConstants.ARM_LENGTH, ElbowConstants.ARM_MASS_KG),
			ElbowConstants.ARM_LENGTH,
			ElbowConstants.BACKWARD_ANGLE_LIMIT.getRadians(),
			ElbowConstants.FORWARD_ANGLE_LIMIT.getRadians(),
			false,
			ElbowConstants.STARTING_POSITION.getRadians()
		);
		pidController = SimulationConstants.PID_CONTROLLER;
		feedForwardController = SimulationConstants.FEEDFORWARD_CONTROLLER;
	}

	public void setVoltage(double voltage) {
		double appliedVoltage = MathUtil
			.clamp(voltage, -GlobalConstants.MAX_BATTERY_VOLTAGE, GlobalConstants.MAX_BATTERY_VOLTAGE);
		motor.setInputVoltage(appliedVoltage);
		System.out.println(appliedVoltage);
	}

	public void setPower(double power) {
		setVoltage(power * GlobalConstants.MAX_BATTERY_VOLTAGE);
	}

	public void goToPosition(Rotation2d targetPosition) {
		pidController.setSetpoint(targetPosition.getRadians());
		setVoltage(pidController.calculate(getPosition().getRadians())
//				+ feedForwardController.calculate(getPosition().getDegrees(), getVelocity().getRotations())
		);
	}

	@Override
	public void updateInputs(ElbowInputsAutoLogged inputs) {
		inputs.position = Rotation2d.fromRadians(motor.getAngleRads());
		inputs.velocity = Rotation2d.fromRadians(motor.getVelocityRadPerSec());
		inputs.current = motor.getCurrentDrawAmps();
		inputs.voltage = motor.getOutput(0);
		motor.update(0.02);
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
