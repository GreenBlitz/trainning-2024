package training.Elbow;

import edu.wpi.first.math.geometry.Rotation2d;

public class ElbowConstants {

	// * These constants are temp and shall be replaced with calibrated constants that aren't 0

	protected static final String LOG_PATH = "";


	public static final Rotation2d DEFAULT_POSITION = new Rotation2d(1, 1);

	public static final Rotation2d SCORE_POSITION = new Rotation2d(0, 0);

	public static final Rotation2d PICKUP_POSITION = new Rotation2d(0, 0);


	protected static final double DEFAULT_TIME_IN_AIR_SECONDS = 0.1;


	protected static final Rotation2d LIFTING_POSITION_DEGREES = Rotation2d.fromDegrees(30);

	protected static final Rotation2d TOLERANCE = new Rotation2d(0);


}
