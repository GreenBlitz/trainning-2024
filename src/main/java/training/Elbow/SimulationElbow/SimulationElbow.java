package training.Elbow.SimulationElbow;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.simulation.SingleJointedArmSim;
import training.Elbow.ElbowInputsAutoLogged;
import training.Elbow.IElbow;
import utils.simulation.SingleJointedArmSimulation;

public class SimulationElbow implements IElbow {

	private final SingleJointedArmSimulation arm;

	public SimulationElbow() {
		this.arm = new SingleJointedArmSimulation(
			new SingleJointedArmSim(
				SimulationElbowConstants.GEARBOX,
				SimulationElbowConstants.GEARING,
				SingleJointedArmSim.estimateMOI(SimulationElbowConstants.LENGTH_METERS, SimulationElbowConstants.MASS),
				SimulationElbowConstants.LENGTH_METERS,
				SimulationElbowConstants.MINIMUM_ANGLE.getRadians(),
				SimulationElbowConstants.MAXIMUM_ANGLE.getRadians(),
				true,
				0
			)
		);
	}

	@Override
	public void moveToAngle(Rotation2d targetAngle) {
		double targetAngelRotations = targetAngle.getRotations() % 1;
		double feedForwardOutputVoltage = SimulationElbowConstants.FEEDFORWARD
			.calculate(arm.getPosition().getRadians(), arm.getVelocity().getRadians());

		arm.setPower(
			SimulationElbowConstants.CONTROLLER.calculate(targetAngelRotations, targetAngle.getRadians())
				+ feedForwardOutputVoltage
		);
	}

	@Override
	public void updateInputs(ElbowInputsAutoLogged inputs) {
		inputs.outputCurrent = arm.getCurrent();
		inputs.position = arm.getPosition();
		inputs.velocity = arm.getVelocity();
	}

}