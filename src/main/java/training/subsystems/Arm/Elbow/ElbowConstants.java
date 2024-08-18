package training.subsystems.Arm.Elbow;

import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.geometry.Rotation2d;

public class ElbowConstants {
    public static final int MOTOR_ID = 0;
    public static final Rotation2d STARTING_POSITION = Rotation2d.fromDegrees(67);

    public static final double KP = 0.4;
    public static final double KI = 0;
    public static final double KD = 1.5;
    public static final Rotation2d ANGULAR_TOLERANCE = Rotation2d.fromDegrees(1.8);
    public static final ArmFeedforward FEED_FORWARD_PARAMETERS = new ArmFeedforward(1, 1, 0);
    public static final double ARM_LENGTH = 0.44;
    public static final double ARM_MASS_KG = 0.44;
    public static final Rotation2d BACKWARD_ANGLE_LIMIT = Rotation2d.fromDegrees(0);
    public static final Rotation2d FORWARD_ANGLE_LIMIT = Rotation2d.fromRotations(999);

}
