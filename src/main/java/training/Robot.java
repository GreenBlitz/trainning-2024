package training;

import training.subsystems.Arm.Elbow.Elbow;
import training.subsystems.Arm.Elbow.ElbowFactory;

public class Robot {

	// Enter your subsystems...
	private final Elbow elbow;

	public enum RobotType {
		SIMULATION,
		REAL
	}

	public static final RobotType REAL = RobotType.REAL;
	public static final RobotType SIMULATION = RobotType.SIMULATION;

	public Robot() {
		// Boot your subsystems...
		this.elbow = new Elbow(ElbowFactory.create());
	}


	// Add your subsystems getters...
	public Elbow getElbow() {
		return elbow;
	}

}

