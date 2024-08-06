package utils.simulation;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.simulation.SingleJointedArmSim;
import utils.DefaultRobotManager;

public class SingleJointedArmSimu extends MotorSimulation {

	private final SingleJointedArmSim armSimulation;

	public SingleJointedArmSimu(SingleJointedArmSim armSimulation) {
		this.armSimulation = armSimulation;
	}

	public double getCurrent() {
		return armSimulation.getCurrentDrawAmps();
	}

	@Override
	public Rotation2d getPosition() {
		return Rotation2d.fromRadians(armSimulation.getAngleRads());
	}

	@Override
	public Rotation2d getVelocity() {
		return Rotation2d.fromRadians(armSimulation.getVelocityRadPerSec());
	}

	@Override
	protected void setInputVoltage(double voltage) {
		armSimulation.setInputVoltage(voltage);
	}

	@Override
	protected void updateMotor() {
		armSimulation.update(DefaultRobotManager.defaultPeriodSecs);
	}

}
