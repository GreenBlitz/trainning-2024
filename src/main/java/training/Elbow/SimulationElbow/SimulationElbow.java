package training.Elbow.SimulationElbow;

import com.ctre.phoenix6.controls.PositionVoltage;
import edu.wpi.first.math.geometry.Rotation2d;
import training.Elbow.ElbowInputsAutoLogged;
import training.Elbow.IElbow;
import utils.simulation.SimpleMotorSimulation;

public class SimulationElbow implements IElbow {

//	private final SingleJointedArmSimulation arm;
	private final SimpleMotorSimulation arm;

	public SimulationElbow() {
		this.arm = new SimpleMotorSimulation();
		arm.applyConfiguration(SimulationElbowConstants.CONFIG);
	}

	@Override
	public void moveToAngle(Rotation2d targetAngle) {
		arm.setControl(new PositionVoltage(targetAngle.getRotations()));
	}

	@Override
	public void updateInputs(ElbowInputsAutoLogged inputs) {
		inputs.outputCurrent = arm.getCurrent();
		inputs.position = arm.getPosition();
		inputs.velocity = arm.getVelocity();
	}

}
