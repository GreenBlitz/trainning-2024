package training.subsystems.Arm.Elbow;

import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.geometry.Rotation2d;

public class NeoElbowConstants {

	protected static final int MOTOR_ID = 0;

	protected static final double TOLERANCE = 5;

	public enum PresetPositions {

		SAFE(Rotation2d.fromDegrees(-67)),
		INTAKE(Rotation2d.fromDegrees(-76)),
		SCORE(Rotation2d.fromDegrees(55)),
		STARTING(Rotation2d.fromDegrees(0)),
		TRANSFER(Rotation2d.fromDegrees(-80));

		public final Rotation2d ANGLE;

		PresetPositions(Rotation2d angle) {
			this.ANGLE = angle;
		}

	}

	protected static final double KS = 0;

	protected static final double KG = 0.12;

	protected static final double KV = 0;

	protected static final double KA = 0;

	protected static final ArmFeedforward ARM_FEEDFORWARD = new ArmFeedforward(
		KS,
		KG,
		KV,
		KA
	);

	protected static final int PID_SLOT = 0;

	protected static final double P = 89;

	protected static final double I = 76;

	protected static final double D = 45;

	public static final double ELBOW_GEAR_RATIO = (1 / (28.0 * (60.0 / 16.0)));

}
