package subsystems.elbow.neoElbow;

import edu.wpi.first.math.controller.ArmFeedforward;

class NeoElbowConstants {

	public static final double KP = 0;

	public static final double KI = 0;

	public static final double KD = 0;

	protected static final ArmFeedforward FEED_FORWARD = new ArmFeedforward(0, 0, 0); // TODO replace with useful FF values

	protected static final int PID_SLOT = 0;

	protected static final int MOTOR_ID = 5;


}
