package training.Elbow;

import training.Elbow.NeoElbow.BrokenNeoElbow;
import training.Elbow.SimulationElbow.SimulationElbow;
import training.Robot;

public class ElbowFactory {

	public IElbow create() {
		return switch (Robot.robotType) {
			case SIMULATION -> new SimulationElbow();
			case SYNCOPA -> new BrokenNeoElbow();
		};
	}

}
