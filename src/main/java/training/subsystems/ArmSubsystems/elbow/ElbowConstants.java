package training.subsystems.ArmSubsystems.elbow;

import edu.wpi.first.math.geometry.Rotation2d;

public class ElbowConstants {


	public static final Rotation2d STARTING_POSITION = Rotation2d.fromDegrees(-82);
	public static final Rotation2d CLIMBING_POSITION = Rotation2d.fromDegrees(55);

	public static final Rotation2d TOLERANCE = Rotation2d.fromDegrees(5);

	public static final Rotation2d GEAR_RATIO = Rotation2d.fromDegrees(1 / (28.0 * (60.0 / 16.0)));

	public static final double ARM_LENGTH = 0.44;
	public static final double ARM_MASS_KG = 0.44;

	public static final Rotation2d BACKWARD_ANGLE_LIMIT = Rotation2d.fromDegrees(-81);
	public static final Rotation2d FORWARD_ANGLE_LIMIT = Rotation2d.fromDegrees(90);

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

}

