package training.subsystems.ArmSubsystems.elbowSubsystem;

import training.Robot;
import training.subsystems.ArmSubsystems.elbowSubsystem.neoElbow.NeoElbow;
import training.subsystems.ArmSubsystems.elbowSubsystem.simulationElbow.SimulationElbow;

public class ElbowFactory {

	public static IElbow create() {
		return switch (Robot.ROBOT_TYPE) {
			case SYNCOPA -> NeoElbow.getInstance();
			case SIMULATION -> SimulationElbow.getInstance();
		};
	}

}
