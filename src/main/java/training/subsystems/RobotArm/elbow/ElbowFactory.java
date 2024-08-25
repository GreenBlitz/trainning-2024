package training.subsystems.RobotArm.elbow;

import training.GeneralConstants;
import training.RobotType;

public class ElbowFactory {

	public static IElbow create() {
		return switch (GeneralConstants.robotTypes){
			case SYNCOPA -> new ElbowNEO();

			case SIMULATION ->  new ElbowSimulation();

		};

	}

}
