package training.subsystems.elbow;


import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.geometry.Rotation2d;

public class ElbowConstants {

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


	public static final int MOTOR_ID = 5;
	public static final int P = 1;
	public static final int I = 0;
	public static final int D = 0;

	public static final int PID_SLOT = 0;

	public static final int KS = 0;
	public static final int KA = 0;
	public static final int KG = 0;
	public static final int KV = 0;
	public static final Rotation2d BACKWARD_ANGLE_LIMIT = Rotation2d.fromDegrees(-81);
	public static final Rotation2d FORWARD_ANGLE_LIMIT = Rotation2d.fromDegrees(90);
	public static final Rotation2d TOLERANCE = Rotation2d.fromDegrees(3);
}