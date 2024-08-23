package training;

import training.subsystems.elbow.Elbow;

public class Robot {

	// Enter your subsystems...
	private Elbow elbow;

	public Robot() {
		// Boot your subsystems...
		elbow = Elbow.getInstance();
	}

	// Add your subsystems getters...

}
