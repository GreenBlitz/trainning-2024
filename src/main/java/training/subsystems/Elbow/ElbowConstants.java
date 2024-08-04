package training.subsystems.Elbow;

import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.geometry.Rotation2d;
import training.RobotType;

public class ElbowConstants {
    public static final int MOTOR_ID = 0;
    public static final Rotation2d STARTING_POSITION = Rotation2d.fromDegrees(67);
    public static final double POSITION_CONVERSION_FACTOR = 1; //check and change
    public static final double VELOCITY_CONVERSION_FACTOR = 1; //check and change

    public static final double KP_VALUE = 45;
    public static final double KI_VALUE = 0;
    public static final double KD_VALUE = 0;
    public static final Rotation2d ANGULAR_TOLERANCE = Rotation2d.fromDegrees(1.8);
    public static final ArmFeedforward FEED_FORWARD_PARAMETERS = new ArmFeedforward(1, 1, 0);
    public static final RobotType ROBOT_TYPE = RobotType.SYNCOPA;
    public static final double ARM_LENGTH = 1;
    public static final double ARM_MASS_KG = 1;
    public static final Rotation2d BACKWARD_ANGLE_LIMIT = Rotation2d.fromDegrees(360);
    public static final Rotation2d FORWARD_ANGLE_LIMIT = Rotation2d.fromDegrees(360);

}
