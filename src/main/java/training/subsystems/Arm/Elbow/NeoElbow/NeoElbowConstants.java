package training.subsystems.Arm.Elbow.NeoElbow;

import edu.wpi.first.math.controller.ArmFeedforward;

public class NeoElbowConstants {

	protected static final int ID = 0;

	public static final double GEAR_RATIO = (1 / (28.0 * (60.0 / 16.0)));

	protected static final double KS = 0;

	protected static final double KG = 0;

	protected static final double KV = 0;

	protected static final double KA = 0;

	protected static final ArmFeedforward FEEDFORWARD = new ArmFeedforward(KS, KG, KV, KA);

	protected static final int PID_SLOT = 0;

	protected static final double P = 1;

	protected static final double I = 0;

	protected static final double D = 0;


}
