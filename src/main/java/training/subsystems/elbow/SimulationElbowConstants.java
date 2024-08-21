package training.subsystems.elbow;

import edu.wpi.first.math.controller.PIDController;

public class SimulationElbowConstants {

	public static final int NUMBER_OF_MOTORS = 1;
	public static final double GEAR_RATIO = 1 / ElbowConstants.GEAR_RATIO;

	public static final double P = 1;

	public static final double I = 0;

	public static final double D = 0;

	public static final PIDController PID = new PIDController(1,0,0);

}