package subsystems.elbow;

import edu.wpi.first.math.geometry.Rotation2d;

public class ElbowConstants {

	public static final double KP = 0;

	public static final double KI = 0;

	public static final double KD = 0;


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

	public static final Rotation2d ANGLE_TOLERANCE = Rotation2d.fromRotations(0.05);

}
