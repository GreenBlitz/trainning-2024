package training.subsystems.ArmSubsystems.elbow;

import training.Robot;
import training.subsystems.ArmSubsystems.elbow.neoElbow.NeoElbow;
import training.subsystems.ArmSubsystems.elbow.simulation.SimulationElbow;

public class ElbowFactory {

	public static IElbow create() {
		return switch (Robot.ROBOT_TYPE) {
			case SYNCOPA -> new NeoElbow();
			case SIMULATION -> new SimulationElbow();
		};
	}

}
