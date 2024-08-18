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

public class SimulationElbow implements IElbow {

	private final SingleJointedArmSim motor;
	private final PIDController pidController;
	private final ArmFeedforward feedForwardController;

	public SimulationElbow() {
		this.motor = new SingleJointedArmSim(
			DCMotor.getNEO(SimulationElbowConstants.NUMBER_OF_MOTORS),
			SimulationElbowConstants.GEAR_RATIO.getDegrees(),
			SingleJointedArmSim.estimateMOI(ElbowConstants.ARM_LENGTH, ElbowConstants.ARM_MASS_KG),
			ElbowConstants.ARM_LENGTH,
			ElbowConstants.BACKWARD_ANGLE_LIMIT.getRadians(),
			ElbowConstants.FORWARD_ANGLE_LIMIT.getRadians(),
			true,
			ElbowConstants.STARTING_POSITION.getRadians()
		);
		pidController = SimulationElbowConstants.PID_CONTROLLER;
		feedForwardController = SimulationElbowConstants.FEEDFORWARD_CONTROLLER;
	}

	public void setVoltage(double voltage) {
		double appliedVoltage = MathUtil
			.clamp(voltage, -GlobalConstants.MAX_BATTERY_VOLTAGE, GlobalConstants.MAX_BATTERY_VOLTAGE);
		motor.setInputVoltage(appliedVoltage);
	}

	public void setPower(double power) {
		setVoltage(power * GlobalConstants.MAX_BATTERY_VOLTAGE);
	}

	public void goToPosition(Rotation2d targetPosition) {
		setVoltage(
			pidController.calculate(getPosition().getRadians(), targetPosition.getRadians())
				+ feedForwardController.calculate(getPosition().getRadians(), 0)
		);
	}

	@Override
	public void stayAtPosition() {
		setVoltage(
			SimulationElbowConstants.FEEDFORWARD_CONTROLLER.calculate(getPosition().getRadians(), 0)
				+ pidController.calculate(getPosition().getRadians(), getPosition().getRadians())
		);
	}

	@Override
	public void updateInputs(ElbowInputsAutoLogged inputs) {
		inputs.position = Rotation2d.fromRadians(motor.getAngleRads());
		inputs.velocity = Rotation2d.fromRadians(motor.getVelocityRadPerSec());
		inputs.current = motor.getCurrentDrawAmps();
		inputs.voltage = motor.getOutput(0);
		motor.update(SimulationElbowConstants.CYCLE_TIME);
	}

	public Rotation2d getPosition() {
		return Rotation2d.fromRadians(motor.getAngleRads());
	}

	public Rotation2d getVelocity() {
		return Rotation2d.fromRotations(motor.getVelocityRadPerSec());
	}

}
