package training.Roller;

import training.Robot;
import training.Roller.NeoRoller.NeoRoller;
import training.Roller.SimulationRoller.SimulationRoller;

public class RollerFactory {

	public IRoller create() {
		return switch (Robot.getRobotType()) {
			case SIMULATION -> new SimulationRoller();
			case SYNCOPA -> new NeoRoller();
		};
	}

}
