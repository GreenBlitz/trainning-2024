package utils.simulation;

import com.ctre.phoenix6.hardware.TalonFX;

import java.util.ArrayList;
import java.util.List;

public class SimulationManager {

	private static final List<MotorSimulation> REGISTERED_SIMULATIONS = new ArrayList<>();

	static TalonFX createNewMotorForSimulation() {
		return new TalonFX(REGISTERED_SIMULATIONS.size());
	}

	static void addSimulation(MotorSimulation simulation) {
		REGISTERED_SIMULATIONS.add(simulation);
	}

	public static void updateRegisteredSimulations() {
		for (MotorSimulation motorSimulation : REGISTERED_SIMULATIONS) {
			motorSimulation.updateSimulation();
		}
	}

}
