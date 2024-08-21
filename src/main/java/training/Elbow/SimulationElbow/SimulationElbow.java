package training.Elbow.SimulationElbow;

import com.ctre.phoenix6.controls.PositionVoltage;
import edu.wpi.first.math.geometry.Rotation2d;
import training.Elbow.ElbowInputsAutoLogged;
import training.Elbow.IElbow;
import utils.simulation.SimpleMotorSimulation;

public class SimulationElbow implements IElbow {

	private final SimpleMotorSimulation arm;
	private final PositionVoltage control;

	public SimulationElbow() {
		this.control = new PositionVoltage(0);
		this.arm = new SimpleMotorSimulation();

		control.EnableFOC = true;
		arm.applyConfiguration(SimulationElbowConstants.CONFIG);
	}

	@Override
	public void moveToAngle(Rotation2d targetAngle) {
		control.Position = targetAngle.getRotations();
		arm.setControl(control);
	}

	@Override
	public void updateInputs(ElbowInputsAutoLogged inputs) {
		inputs.outputCurrent = arm.getCurrent();
		inputs.position = arm.getPosition();
		inputs.velocity = arm.getVelocity();
	}

}
