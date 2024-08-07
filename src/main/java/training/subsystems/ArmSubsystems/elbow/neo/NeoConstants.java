package training.subsystems.ArmSubsystems.elbow.neo;

import edu.wpi.first.math.controller.ArmFeedforward;

public class NeoConstants {

	public static final int ID = 5;

	public static final double P_VALUE = 10;
	public static final double I_VALUE = 0;
	public static final double D_VALUE = 0;

	public static final double KS_VALUE = 0;
	public static final double KG_VALUE = 0;
	public static final double KV_VALUE = 0;
	public static final double KA_VALUE = 0;

	public static final ArmFeedforward FEEDFORWARD_CONTROLLER = new ArmFeedforward(KS_VALUE, KG_VALUE, KV_VALUE, KA_VALUE);

}
