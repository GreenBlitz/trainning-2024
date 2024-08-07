package training.subsystems.Arm.Elbow;

import edu.wpi.first.math.geometry.Rotation2d;

public class ElbowConstants {

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

	public static final double GEAR_RATIO = (1 / (28.0 * (60.0 / 16.0)));

}
