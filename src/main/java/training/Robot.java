package training;

import subsystems.Roller.Roller;
import subsystems.elbow.Elbow;
import subsystems.wrist.Wrist;

public class Robot {

	public enum RobotType {
		SIMULATION,
		REAL
	}

	public static final RobotType ROBOT_TYPE = RobotType.SIMULATION;


	// Enter your subsystems...
	private final Elbow elbow;
	private final Wrist wrist;
	private final Roller roller;

	public Robot() {
		// Boot your subsystems...
		this.elbow = Elbow.getInstance();
		this.wrist = Wrist.getInstance();
		this.roller = Roller.getInstance();
	}

	// Add your subsystems getters...

}
