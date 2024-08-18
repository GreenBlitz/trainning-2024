package training.subsystems.ArmSubsystems.wrist;

import edu.wpi.first.math.geometry.Rotation2d;

public class WristConstants {


	public static final Rotation2d STARTING_POSITION = Rotation2d.fromDegrees(90);
	public static final Rotation2d CLIMBING_POSITION = Rotation2d.fromDegrees(390);

	public static final Rotation2d TOLERANCE = Rotation2d.fromDegrees(5);

	public static final double ARM_LENGTH = 0.44;
	public static final double ARM_MASS_KG = 0.44;

	public static final Rotation2d BACKWARD_ANGLE_LIMIT = Rotation2d.fromDegrees(-999999999);
	public static final Rotation2d FORWARD_ANGLE_LIMIT = Rotation2d.fromDegrees(999999999);

	public static final double MAG_ENCODER_CONVERSION_FACTOR = 8192;
	public static final double CONVERSION_FACTOR = 1;
	public static final int TIMEOUT_FOR_CONFIG_SET = 1;

}
