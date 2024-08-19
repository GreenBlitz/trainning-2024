package training.subsystems.Arm.Elbow;

import training.Robot;
import training.subsystems.Arm.Elbow.NeoElbow.NeoElbow;
import training.subsystems.Arm.Elbow.SimulationElbow.SimulationElbow;

public class ElbowFactory {

	public static IElbow create() {
		return switch (Robot.SIMULATION) {
			case REAL -> new NeoElbow();
			case SIMULATION -> new SimulationElbow();
		};
	}

}
