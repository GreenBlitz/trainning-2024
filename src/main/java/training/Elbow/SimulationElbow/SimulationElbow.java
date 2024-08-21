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

	@Override
	public void updatePID(double kP, double kI, double kD) {
		if (kP == -1) {
			kP = SimulationElbowConstants.CONFIG.Slot0.kP;
		}
		if (kI == -1) {
			kI = SimulationElbowConstants.CONFIG.Slot0.kI;
		}
		if (kD == -1) {
			kD = SimulationElbowConstants.CONFIG.Slot0.kD;
		}

		SimulationElbowConstants.CONFIG.Slot0.withKP(kP).withKI(kI).withKD(kD);
	}

	@Override
	public void updateFF(double kS, double kG, double kV, double kA) {
		if (kS == -1) {
			kS = SimulationElbowConstants.CONFIG.Slot0.kA;
		}
		if (kG == -1) {
			kG = SimulationElbowConstants.CONFIG.Slot0.kG;
		}
		if (kV == -1) {
			kV = SimulationElbowConstants.CONFIG.Slot0.kV;
		}
		if (kA == -1) {
			kA = SimulationElbowConstants.CONFIG.Slot0.kA;
		}

		SimulationElbowConstants.CONFIG.Slot0.withKS(kS).withKG(kG).withKV(kV).withKA(kA);
	}

}
