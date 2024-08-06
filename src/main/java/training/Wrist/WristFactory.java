package training.Wrist;

import training.Robot;
import training.Wrist.NeoWrist.NeoWrist;
import training.Wrist.SimulationWrist.SimulationWrist;

public class WristFactory {

	public IWrist create() {
		return switch (Robot.getRobotType()) {
			case SIMULATION -> new SimulationWrist();
			case SYNCOPA -> new NeoWrist();
		};
	}

}
