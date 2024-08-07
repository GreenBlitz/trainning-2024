package training.subsystems.Arm.Elbow;

import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.geometry.Rotation2d;

public class NeoElbowConstants {

	protected static final int MOTOR_ID = 0;

	protected static final double TOLERANCE = 5;

	protected static final Rotation2d ELBOW_START_POSITION = Rotation2d.fromDegrees(0);

	protected static final Rotation2d ELBOW_CLIMBING_POSITION = Rotation2d.fromDegrees(180);

	protected static final ArmFeedforward ARM_FEEDFORWARD = new ArmFeedforward(
		NeoElbowConstants.KS,
		NeoElbowConstants.KG,
		NeoElbowConstants.KV,
		NeoElbowConstants.KA
	);

	protected static final int PID_SLOT = 0;

	protected static final double P = 89;

	protected static final double I = 76;

	protected static final double D = 45;

	protected static final double KS = 0;

	protected static final double KG = 0.12;

	protected static final double KV = 0;

	protected static final double KA = 0;

	public static final double ELBOW_GEAR_RATIO = (1 / (28.0 * (60.0 / 16.0)));

}
