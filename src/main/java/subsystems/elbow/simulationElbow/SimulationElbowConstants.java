package subsystems.elbow.simulationElbow;

import edu.wpi.first.math.geometry.Rotation2d;

public class SimulationElbowConstants {

	public static final int NUMBER_OF_MOTORS = 1;

	public static final double GEAR_RATIO = 28.0 * (60.0 / 16.0);

	public static final double ARM_MASS_KG = 0.44;

	public static final double ARM_LENGTH = 0.44;

	public static final Rotation2d BACKWARD_ANGLE_LIMIT = Rotation2d.fromDegrees(-81);

	public static final Rotation2d FORWARD_ANGLE_LIMIT = Rotation2d.fromDegrees(90);

	public static final double FULL_CIRCLE_RAD = 2 * Math.PI;

}
