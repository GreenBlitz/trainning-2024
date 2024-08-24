package training.subsystems.RobotArm.elbow;

import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.geometry.Rotation2d;

public class ElbowConstants {

	public static final double BIGINNING_POSITION = 0, KP = 50, KI = 0, KD = 0, KS = 0, KA = 0, KV = 0, KG = 0,
		ARE_FEED_FORWARDS = 0;
	public static final Rotation2d TOLERANCE = Rotation2d.fromDegrees(3);

	public enum PresetPositions {

		SAFE(Rotation2d.fromDegrees(0)),
		INTAKE(Rotation2d.fromDegrees(0)),
		SCORE(Rotation2d.fromDegrees(0)),
		STARTING(Rotation2d.fromDegrees(0)),
		TRANSFER(Rotation2d.fromDegrees(0));

		public final Rotation2d ANGLE;

		PresetPositions(Rotation2d angle) {
			this.ANGLE = angle;
		}

	}

	protected static ArmFeedforward ARM_FEED_FORWARD = new ArmFeedforward(KS, KG, KV, KA);

	public static final int MOTOR_ID = 0, PID_SLOT = 0;

	public static final double ARM_LENGTH = 0.44;

	public static final Rotation2d BACKWARD_ANGLE_LIMIT = Rotation2d.fromDegrees(-81);

	public static final Rotation2d FORWARD_ANGLE_LIMIT = Rotation2d.fromDegrees(90);

	public static final double ARM_MASS_KG = 0.44;

}
