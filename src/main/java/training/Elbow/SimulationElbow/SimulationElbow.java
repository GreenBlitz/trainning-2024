package training.Elbow.SimulationElbow;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.simulation.SingleJointedArmSim;
import training.Elbow.IElbow;
import utils.simulation.SingleJointedArmSimulation;

public class SimulationElbow implements IElbow {

	private final SingleJointedArmSimulation arm;

	public SimulationElbow() {
		this.arm = new SingleJointedArmSimulation(
			new SingleJointedArmSim(
				SimulationElbowConatns.ELBOW_GEARBOX,
				SimulationElbowConatns.ELBOW_GEARING,
				SingleJointedArmSim.estimateMOI(SimulationElbowConatns.ELBOW_LENGTH_METERS, SimulationElbowConatns.ELBOW_MASS),
				SimulationElbowConatns.ELBOW_LENGTH_METERS,
				SimulationElbowConatns.ELBOW_MINIMUM_ANGLE.getRadians(),
				SimulationElbowConatns.ELBOW_MAXIMUM_ANGLE.getRadians(),
				true,
				0
			)
		);
	}

	@Override
	public Rotation2d getCurrentAngle() {
		return arm.getPosition();
	}

	@Override
	public Rotation2d getCurrentVelocity() {
		return arm.getVelocity();
	}

	@Override
	public void updateAngle(Rotation2d targetAngle) {
		double target = targetAngle.getRotations() % 1;
		double FFValue = SimulationElbowConatns.SIMULATION_ELBOW_FEEDFORWARD
			.calculate(getCurrentAngle().getRadians(), arm.getVelocity().getRadians());

		arm.setPower(SimulationElbowConatns.CONTROLLER.calculate(target, targetAngle.getRadians()) + FFValue);
	}

}
