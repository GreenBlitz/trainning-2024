package training.Wrist.SimulationWrist;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.simulation.DCMotorSim;
import edu.wpi.first.wpilibj.simulation.SingleJointedArmSim;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import training.Wrist.IWrist;
import training.Wrist.WristInputsAutoLogged;

public class SimulationWrist implements IWrist {

	private final DCMotorSim motor;
	private boolean inTestingMode;

	public SimulationWrist() {
		this.motor = new DCMotorSim(
			DCMotor.getNEO(1),
			SimulationWristConstants.GEARING,
			SingleJointedArmSim.estimateMOI(SimulationWristConstants.LENGTH_METERS, SimulationWristConstants.MASS_KG)
		);
	}

	/**
	 * Don't use this in production code. It's here only for debugging etc.
	 */
	@Deprecated
	public void setPower(double power) {
		inTestingMode = true;
		if (Math.abs(power) >= SimulationWristConstants.POWER_LIMIT) {
			SmartDashboard.putString("Reverting to max speed 0.9", "");
			power = 0.9;
		}

		motor.setInputVoltage(power);
	}

	@Override
	public void moveToAngle(Rotation2d targetAngle) {
		motor.setInputVoltage(
			SimulationWristConstants.CONTROLLER.calculate(motor.getAngularPositionRotations(), targetAngle.getRotations())
		);
	}

	@Override
	public void updateInputs(WristInputsAutoLogged inputs) {
		inputs.position = Rotation2d.fromRadians(motor.getAngularPositionRad());
		inputs.velocity = Rotation2d.fromRadians(motor.getAngularVelocityRadPerSec());
	}

}
