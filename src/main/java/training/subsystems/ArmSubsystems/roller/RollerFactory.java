package training.subsystems.ArmSubsystems.roller;

import training.Robot;
import training.subsystems.ArmSubsystems.roller.NeoRoller.NeoRoller;
import training.subsystems.ArmSubsystems.roller.simulationRoller.SimulationRoller;

public class RollerFactory {

	public static IRoller create() {
		return switch (Robot.ROBOT_TYPE) {
			case SYNCOPA -> new NeoRoller();
			case SIMULATION -> new SimulationRoller();
		};
	}

}
