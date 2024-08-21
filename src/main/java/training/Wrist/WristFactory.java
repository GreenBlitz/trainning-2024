package training.Wrist;

import training.Robot;
import training.Wrist.NeoWrist.NeoWrist;
import training.Wrist.SimulationWrist.SimulationWrist;

public class WristFactory {

	static public IWrist create() {
		return switch (Robot.ROBOT_TYPE) {
			case SIMULATION -> new SimulationWrist();
			case SYNCOPA -> new NeoWrist();
		};
	}

}
