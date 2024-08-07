package training.subsystems.ArmSubsystems.elbow;

import training.Robot;
import training.subsystems.ArmSubsystems.elbow.neo.Neo;
import training.subsystems.ArmSubsystems.elbow.simulation.Simulation;

public class ElbowFactory {

	public static IElbow create() {
		return switch (Robot.ROBOT_TYPE) {
			case SYNCOPA -> new Neo();
			case SIMULATION -> new Simulation();
		};
	}

}
