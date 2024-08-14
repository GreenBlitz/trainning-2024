package training.subsystems.ArmSubsystems.wrist;

import training.Robot;
import training.subsystems.ArmSubsystems.wrist.simulationWrist.SimulationWrist;
import training.subsystems.ArmSubsystems.wrist.talonWrist.TalonWrist;

public class WristFactory {

	public static IWrist create() {
		return switch (Robot.ROBOT_TYPE) {
			case SYNCOPA -> new TalonWrist();
			case SIMULATION -> new SimulationWrist();
		};
	}

}
