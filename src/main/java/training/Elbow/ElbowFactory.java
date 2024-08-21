package training.Elbow;

import training.Elbow.NeoElbow.NeoElbow;
import training.Elbow.SimulationElbow.SimulationElbow;
import training.Robot;

public class ElbowFactory {

	static public IElbow create() {
		return switch (Robot.ROBOT_TYPE) {
			case SIMULATION -> new SimulationElbow();
			case SYNCOPA -> new NeoElbow();
		};
	}

}
