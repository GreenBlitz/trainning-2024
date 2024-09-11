package subsystems.wrist.simulationWrist;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.simulation.SingleJointedArmSim;
import subsystems.GlobalConstants;
import subsystems.elbow.simulationElbow.SimulationElbowConstants;
import subsystems.wrist.IWrist;
import subsystems.wrist.WristConstants;
import subsystems.wrist.WristInputsAutoLogged;

public class SimulationWrist implements IWrist {

	private final SingleJointedArmSim motor;

	private final PIDController controller;

	public SimulationWrist() {
		motor = new SingleJointedArmSim(
			DCMotor.getNEO(SimulationWristConstants.NUMBER_OF_MOTORS),
			SimulationWristConstants.GEAR_RATIO,
			SingleJointedArmSim.estimateMOI(WristConstants.LENGTH_OF_ENDEFFECTOR, WristConstants.WRIST_MASS_KG),
			WristConstants.LENGTH_OF_ENDEFFECTOR,
			WristConstants.BACKWARD_ANGLE_LIMIT.getRadians(),
			WristConstants.FORWARD_ANGLE_LIMIT.getRadians(),
			false,
			WristConstants.PresetPositions.STARTING.ANGLE.getRadians()
		);

		controller = new PIDController(SimulationWristConstants.KP, SimulationWristConstants.KI, SimulationWristConstants.KD);
	}


	@Override
	public void setPower(double power) {
		setVoltage(power * GlobalConstants.SIMULATION_BATTERY_VOLTAGE);
	}

	private void setVoltage(double voltage) {
		double limited_voltage = Math
			.min((Math.max(voltage, -GlobalConstants.SIMULATION_BATTERY_VOLTAGE)), GlobalConstants.SIMULATION_BATTERY_VOLTAGE);
		motor.setInputVoltage(limited_voltage);
	}

	@Override
	public void updateInputs(WristInputsAutoLogged inputs) {
		inputs.angle = Rotation2d.fromRadians(motor.getAngleRads());
		motor.update(SimulationElbowConstants.MOTOR_UPDATE_PERIOD);
	}

	@Override
	public void goToPosition(Rotation2d position) {
		setVoltage(controller.calculate(motor.getAngleRads(), position.getRadians()));
	}

}
