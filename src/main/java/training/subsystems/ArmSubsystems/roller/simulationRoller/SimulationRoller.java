package training.subsystems.ArmSubsystems.roller.simulationRoller;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.simulation.DCMotorSim;
import training.GlobalConstants;
import training.subsystems.ArmSubsystems.roller.IRoller;
import training.subsystems.ArmSubsystems.roller.RollerInputsAutoLogged;

public class SimulationRoller implements IRoller {

	private final DCMotorSim motor;


	public SimulationRoller() {
		this.motor = new DCMotorSim(
			DCMotor.getNEO(SimulationRollerConstants.NUMBER_OF_MOTORS),
			SimulationRollerConstants.GEAR_RATIO,
			SimulationRollerConstants.MOMENT_OF_INERTIA
		);
	}

	public void setPower(double power) {
		setVoltage(power * GlobalConstants.MAX_BATTERY_VOLTAGE);
	}

	public void setVoltage(double voltage) {
		motor.setInputVoltage(voltage);
	}

	@Override
	public void updateInputs(RollerInputsAutoLogged inputs) {
		inputs.position = Rotation2d.fromRotations(motor.getAngularPositionRotations());
		inputs.velocity = Rotation2d.fromRadians(motor.getAngularVelocityRadPerSec());
	}


}
