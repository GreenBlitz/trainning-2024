package training.Roller;

import training.Robot;
import training.Roller.NeoRoller.NeoRoller;
import training.Roller.SimulationRoller.SimulationRoller;

public class RollerFactory {

	public IRoller create() {
		return switch (Robot.ROBOT_TYPE) {
			case SIMULATION -> new SimulationRoller();
			case SYNCOPA -> new NeoRoller();
		};
	}

}
