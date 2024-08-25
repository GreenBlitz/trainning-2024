package subsystems.elbow.simulationElbow;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.simulation.SingleJointedArmSim;
import subsystems.GlobalConstants;
import subsystems.elbow.ElbowConstants;
import subsystems.elbow.IElbow;

public class SimulationElbow implements IElbow {

	private final SingleJointedArmSim motor;
	private final PIDController controller;

	public SimulationElbow() {
		this.motor = new SingleJointedArmSim(
			DCMotor.getFalcon500(SimulationElbowConstants.NUMBER_OF_MOTORS),
			SimulationElbowConstants.GEAR_RATIO,
			SingleJointedArmSim.estimateMOI(SimulationElbowConstants.ARM_LENGTH, SimulationElbowConstants.ARM_MASS_KG),
			SimulationElbowConstants.ARM_LENGTH,
			SimulationElbowConstants.BACKWARD_ANGLE_LIMIT.getRadians(),
			SimulationElbowConstants.FORWARD_ANGLE_LIMIT.getRadians(),
			false,
			ElbowConstants.PresetPositions.STARTING.ANGLE.getRadians()
		);
		this.controller = new PIDController(ElbowConstants.KP, ElbowConstants.KI, ElbowConstants.KD);
	}

	@Override
	public Rotation2d getAngle() {
		return Rotation2d.fromRadians(motor.getAngleRads());
	}

	@Override
	public Rotation2d getVelocity() {
		return Rotation2d.fromRadians(motor.getVelocityRadPerSec() / SimulationElbowConstants.FULL_CIRCLE.getRadians());
	}

	@Override
	public void setPower(double power) {
		setVoltage(power * GlobalConstants.DEFAULT_BATTERY_VOLTAGE);
	}

	private void setVoltage(double voltage) {
		double limited_voltage = Math
			.min((Math.max(voltage, -GlobalConstants.DEFAULT_BATTERY_VOLTAGE)), GlobalConstants.DEFAULT_BATTERY_VOLTAGE);
		motor.setInputVoltage(limited_voltage);
	}

	@Override
	public void goToPosition(Rotation2d position) {
		setVoltage(controller.calculate(motor.getAngleRads(), position.getRadians()));
	}

}
