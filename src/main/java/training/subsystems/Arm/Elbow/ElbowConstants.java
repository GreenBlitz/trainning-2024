package training.subsystems.Arm.Elbow;

import edu.wpi.first.math.geometry.Rotation2d;

public class ElbowConstants {

	protected static final Rotation2d TOLERANCE = Rotation2d.fromDegrees(5);

	public enum PresetPositions {

		SAFE(Rotation2d.fromDegrees(-67)),
		INTAKE(Rotation2d.fromDegrees(-76)),
		SCORE(Rotation2d.fromDegrees(55)),
		STARTING(Rotation2d.fromDegrees(0)),
		TRANSFER(Rotation2d.fromDegrees(-80));

		public final Rotation2d angle;

		PresetPositions(Rotation2d angle) {
			this.angle = angle;
		}

	}

	public static final Rotation2d MINIMUM_ANGLE = Rotation2d.fromDegrees(-82);

	public static final double ARM_LENGTH = 0.44;

	public static final double ARM_DISTANCE_FROM_CENTER = 0.1;

	public static final double ARM_MASS_KG = 0.44;

	public static final Rotation2d BACKWARD_ANGLE_LIMIT = Rotation2d.fromDegrees(-81);

	public static final Rotation2d FORWARD_ANGLE_LIMIT = Rotation2d.fromDegrees(90);

}
