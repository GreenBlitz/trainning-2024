package subsystems.wrist;

import subsystems.wrist.simulationWrist.SimulationWrist;
import subsystems.wrist.talonWrist.TalonWrist;
import training.Robot;

public class WristFactory {

	public static IWrist create() {
		return switch (Robot.ROBOT_TYPE) {
			case REAL -> new TalonWrist();
			case SIMULATION -> new SimulationWrist();
		};
	}


}
