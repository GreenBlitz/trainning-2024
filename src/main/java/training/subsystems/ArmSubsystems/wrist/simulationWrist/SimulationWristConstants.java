package training.subsystems.ArmSubsystems.wrist.simulationWrist;

import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.controller.PIDController;
import training.subsystems.ArmSubsystems.wrist.WristConstants;

public class SimulationWristConstants {

	protected static final int ID = 11;
	public static final int NUMBER_OF_MOTORS = 1;

	public static final int PID_SLOT = 0;

	public static final double GEAR_RATIO = 1 / WristConstants.CONVERSION_FACTOR;

	protected static final double KP = 0.4;
	protected static final double KI = 0;
	protected static final double KD = 0;

	protected static final PIDController PID_CONTROLLER = new PIDController(KP, KI, KD);

	protected static final double KS = 0;
	protected static final double KG = 0;
	protected static final double KV = 0;
	protected static final double KA = 0;

	protected static final ArmFeedforward ARM_FEEDFORWARD = new ArmFeedforward(KS, KG, KV, KA);


}
