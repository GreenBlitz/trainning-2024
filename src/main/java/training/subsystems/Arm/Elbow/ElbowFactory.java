package training.subsystems.Arm.Elbow;

import training.Robot;

public class ElbowFactory {

	public static IElbow create() {
		return switch (Robot.ROBOT_TYPE) {
			case SIMULATION -> new SimulationElbow();
			case REAL -> new NeoElbow();
		};
	}

}
