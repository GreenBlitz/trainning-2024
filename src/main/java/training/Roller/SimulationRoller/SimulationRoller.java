package training.Roller.SimulationRoller;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.simulation.DCMotorSim;
import org.littletonrobotics.junction.Logger;
import training.Roller.IRoller;
import training.Roller.RollerInputsAutoLogged;

public class SimulationRoller implements IRoller {

	private final DCMotorSim motor;
	private double pidOutput;

	public SimulationRoller() {
		this.motor = new DCMotorSim(
			DCMotor.getNEO(1),
			SimulationRollerConstants.GEARING,
			SimulationRollerConstants.POWER_TO_ACCELERATION
		);
	}

	@Override
	public void setPower(double power) {
		motor.setInputVoltage(power);
	}

	@Override
	public void updateVelocity(Rotation2d targetVelocity) {
		Logger.recordOutput("Roller/targetVelocity: ", targetVelocity);
		pidOutput = SimulationRollerConstants.CONTROLLER.calculate(motor.getAngularPositionRad(), targetVelocity.getRadians());
		motor.setInputVoltage(pidOutput);
	}

	@Override
	public void updateInputs(RollerInputsAutoLogged inputs) {
		inputs.outputCurrent = motor.getCurrentDrawAmps();
		inputs.position = Rotation2d.fromRadians(motor.getAngularPositionRad());
		inputs.velocity = Rotation2d.fromRadians(motor.getAngularVelocityRadPerSec());
	}

}
