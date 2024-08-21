package training.subsystems.arm.elbow;


import edu.wpi.first.math.Pair;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation3d;
import edu.wpi.first.math.controller.PIDController;

public class SimulationElbowConstants {


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

	public static final int NUMBER_OF_MOTORS = 1;


	public static final Rotation2d MINIMUM_ANGLE = Rotation2d.fromDegrees(-82);

	public static final double ARM_LENGTH = 0.44;

	public static final double ARM_DISTANCE_FROM_CENTER = 0.1;

	public static final double ARM_MASS_KG = 0.44;

	public static final Rotation2d BACKWARD_ANGLE_LIMIT = Rotation2d.fromDegrees(-81);

	public static final Rotation2d FORWARD_ANGLE_LIMIT = Rotation2d.fromDegrees(90);

	public static final Pair<
		Rotation2d,
		Rotation2d> SHOOTER_COLLISION_RANGE = new Pair<>(BACKWARD_ANGLE_LIMIT, PresetPositions.SAFE.ANGLE);

	public static final Translation3d ELBOW_POSITION_RELATIVE_TO_ROBOT = new Translation3d(-0.1, 0, 0.6);

	public static final double GEAR_RATIO = 1 / (28.0 * (60.0 / 16.0));

	public static final Rotation2d TOLERANCE = Rotation2d.fromDegrees(3);

	public static final int CURRENT_LIMIT = 40;

	public static final PIDController SIMULATION_PID = new PIDController(Constants.KP, Constants.KI, Constants.KD);

	public static final double FULL_CIRCLE_RAD = 2 * Math.PI;;

}

