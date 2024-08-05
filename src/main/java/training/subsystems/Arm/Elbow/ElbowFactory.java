package training.subsystems.Arm.Elbow;

import training.RobotConstants;

public class ElbowFactory {

	public static IElbow create() {
		return switch (RobotConstants.ROBOT_TYPE) {
			case SIMULATION -> SimulationElbow.getInstance();
			case REAL -> NeoElbow.getInstance();
		};
	}

}
