package training.Wrist.SimulationWrist;

import edu.wpi.first.math.controller.PIDController;

public class SimulationWristConstants {

	protected static final double GEARING = 1;

	protected static final double LENGTH_METERS = 0.1;

	protected static final double MASS_KG = 0.5;

	protected static final PIDController CONTROLLER = new PIDController(1, 0, 0);

	protected static final double POWER_LIMIT = 0.9; // limit both min and max

}
