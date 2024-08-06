package training.subsystems.ArmSubsystems.elbowSubsystem;

import training.Robot;
import training.subsystems.ArmSubsystems.elbowSubsystem.neo.NeoElbow;
import training.subsystems.ArmSubsystems.elbowSubsystem.simulation.SimulationElbow;

public class Factory {

	public static IElbow create() {
		return switch (Robot.ROBOT_TYPE) {
			case SYNCOPA -> new NeoElbow();
			case SIMULATION -> new SimulationElbow();
		};
	}

}
