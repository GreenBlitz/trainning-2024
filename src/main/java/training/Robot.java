package training;

import training.subsystems.ArmSubsystems.elbow.Elbow;
//import training.subsystems.ArmSubsystems.roller.Roller;
import training.subsystems.ArmSubsystems.wrist.Wrist;

public class Robot {

	// Enter your subsystems...

	public static final Robot.robotType ROBOT_TYPE = Robot.robotType.SIMULATION;
	private final Elbow elbow;
	private final Wrist wrist;
//	private final Roller roller;


	public Robot() {
		// Boot your subsystems...
		this.elbow = new Elbow();
		this.wrist = new Wrist();
//		this.roller = new Roller();
	}


	public enum robotType {
		SYNCOPA,
		SIMULATION,
	}

	public Elbow getElbow() {
		return elbow;
	}

//	public Roller getRoller() {
//		return roller;
//	}

	public Wrist getWrist() {
		return wrist;
	}

	// Add your subsystems getters...
}
