package training.subsystems.Arm.Elbow.NeoElbow;

import edu.wpi.first.math.controller.ArmFeedforward;

public class NeoElbowConstants {

	protected static final int MOTOR_ID = 0;

	protected static final double TOLERANCE = 5;


	protected static final double KS = 0;

	protected static final double KG = 0.12;

	protected static final double KV = 0;

	protected static final double KA = 0;

	protected static final ArmFeedforward ARM_FEEDFORWARD = new ArmFeedforward(KS, KG, KV, KA);

	protected static final int PID_SLOT = 0;

	protected static final double P = 40;

	protected static final double I = 0;

	protected static final double D = 0;


}
