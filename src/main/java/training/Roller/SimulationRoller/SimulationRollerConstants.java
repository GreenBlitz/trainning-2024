package training.Roller.SimulationRoller;

import edu.wpi.first.math.controller.PIDController;

public class SimulationRollerConstants {

	protected static final double GEARING = 1;

	protected static final double POWER_TO_ACCELERATION = 1;

	protected static final PIDController CONTROLLER = new PIDController(200, 0, 0);

}
