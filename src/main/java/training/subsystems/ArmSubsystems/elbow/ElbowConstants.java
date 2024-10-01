package training.subsystems.ArmSubsystems.elbow;

import edu.wpi.first.math.geometry.Rotation2d;

public class ElbowConstants {


	public static final Rotation2d STARTING_POSITION = Rotation2d.fromDegrees(-81);
	public static final Rotation2d SCORE_POSITION = Rotation2d.fromDegrees(45);
	public static final Rotation2d SAFE_POSITION = Rotation2d.fromDegrees(-45);
	public static final Rotation2d CLIMBING_POSITION = Rotation2d.fromDegrees(-21.2);

	public static final Rotation2d POSITION_TOLERANCE = Rotation2d.fromDegrees(0.25);
	public static final Rotation2d VELOCITY_TOLERANCE = Rotation2d.fromRotations(0.01);


	public static final double ARM_LENGTH = 0.44;
	public static final double ARM_MASS_KG = 0.44;

	public static final Rotation2d BACKWARD_ANGLE_LIMIT = Rotation2d.fromDegrees(-81);
	public static final Rotation2d FORWARD_ANGLE_LIMIT = Rotation2d.fromDegrees(54);


}

