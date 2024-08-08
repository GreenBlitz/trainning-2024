package training;

import training.subsystems.Arm.Elbow.Elbow;

public class Robot {

	// Enter your subsystems...
	private final Elbow elbow;

	public enum RobotType {
		SIMULATION,
		REAL
	}

	public static final RobotType ROBOT_TYPE = RobotType.SIMULATION;

	public Robot() {
		// Boot your subsystems...
		this.elbow = new Elbow();
	}



	// Add your subsystems getters...
	public Elbow getElbow(){
		return elbow;
	}
}

