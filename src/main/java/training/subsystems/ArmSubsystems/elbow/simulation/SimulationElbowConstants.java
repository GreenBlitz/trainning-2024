package training.subsystems.ArmSubsystems.elbow.simulation;

import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Rotation2d;

public class SimulationElbowConstants {

	public static final int ID = 0;

	public static final int NUMBER_OF_MOTORS = 1;

	public static final double KP = 125.6;
	public static final double KI = 0;
	public static final double KD = 0;
	public static final PIDController PID_CONTROLLER = new PIDController(KP, KI, KD);

	public static final Rotation2d GEAR_RATIO = Rotation2d.fromDegrees(28.0 * (60.0 / 16.0));

	public static final double KS = 0;
	public static final double KG = 0.04169848;
	public static final double KV = 0;
	public static final double KA = 0;

	public static final ArmFeedforward ARM_FEEDFORWARD_CONTROLLER = new ArmFeedforward(KS, KG, KV, KA);

}
