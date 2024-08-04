package training;

import com.ctre.phoenix6.configs.Slot0Configs;
import edu.wpi.first.math.geometry.Rotation2d;

public class ElbowConstants {
    public static final int MOTOR_ID = 0;
    public static final Rotation2d STARTING_POSITION = Rotation2d.fromDegrees(67);
    public static final double POSITION_CONVERSION_FACTOR = 1; //check and change
    public static final double VELOCITY_CONVERSION_FACTOR = 1; //check and change

    public static final double KP_VALUE = 45;
    public static final double KI_VALUE = 0;
    public static final double KD_VALUE = 0;
}
