package training.subsystems.ArmSubsystems.wrist.simulationWrist;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.simulation.SingleJointedArmSim;
import training.GlobalConstants;
import training.subsystems.ArmSubsystems.elbow.simulation.SimulationConstants;
import training.subsystems.ArmSubsystems.wrist.IWrist;
import training.subsystems.ArmSubsystems.wrist.WristConstants;
import training.subsystems.ArmSubsystems.wrist.WristInputsAutoLogged;
import utils.simulation.SingleJointedArmSimulation;

public class SimulationWrist implements IWrist {

	private final SingleJointedArmSimulation motor;
	PIDController pidController;
	ArmFeedforward feedForwardController;

	public SimulationWrist() {
		this.motor = new SingleJointedArmSimulation(
			new SingleJointedArmSim(
				DCMotor.getNEO(1),
				SimulationConstants.GEAR_RATIO.getDegrees(),
				SingleJointedArmSim.estimateMOI(WristConstants.ARM_LENGTH, WristConstants.ARM_MASS_KG),
				WristConstants.ARM_LENGTH,
				WristConstants.BACKWARD_ANGLE_LIMIT.getRadians(),
				WristConstants.FORWARD_ANGLE_LIMIT.getRadians(),
				false,
				WristConstants.STARTING_POSITION.getRadians()
			)
		);
		pidController = SimulationConstants.PID_CONTROLLER;
		feedForwardController = SimulationConstants.FEEDFORWARD_CONTROLLER;
	}


	@Override
	public void goToPosition(Rotation2d targetPosition) {
		setVoltage(pidController.calculate(motor.getPosition().getRotations(), targetPosition.getRotations()));
	}

	@Override
	public void setPower(double power) {
		motor.setPower(power);
	}

	@Override
	public void setVoltage(double voltage) {
		double clampedVoltage=MathUtil.clamp(voltage, -GlobalConstants.MAX_BATTERY_VOLTAGE, GlobalConstants.MAX_BATTERY_VOLTAGE);
		double appliedPower =clampedVoltage/ GlobalConstants.MAX_BATTERY_VOLTAGE;
		motor.setPower(appliedPower);
		System.out.println(clampedVoltage);
	}

	@Override
	public void updateInputs(WristInputsAutoLogged inputs) {
		inputs.position = motor.getPosition();
		inputs.velocity = motor.getVelocity();
		inputs.voltage = motor.getVoltage();
	}

}
