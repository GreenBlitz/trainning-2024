package training.subsystems.RobotArm.elbow;

import training.GeneralConstants;

public class ElbowFactory {

	public static IElbow create() {
		return switch (GeneralConstants.ROBOT_TYPE) {
			case SYNCOPA -> new ElbowNEO();
			case SIMULATION -> new ElbowSimulation();
		};
	}

}
