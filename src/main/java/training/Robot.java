package training;

import subsystems.Roller.Roller;
import subsystems.elbow.neoElbow.NeoElbow;
import subsystems.wrist.Wrist;

public class Robot {

	// Enter your subsystems...
	private final NeoElbow elbow;
	private final Wrist wrist;
	private final Roller roller;

	public Robot() {
		// Boot your subsystems...
		elbow = NeoElbow.getInstance();
		wrist = Wrist.getInstance();
		roller = Roller.getInstance();
	}

	// Add your subsystems getters...

}
