package training;

import com.ctre.phoenix6.configs.Slot0Configs;
import edu.wpi.first.math.geometry.Rotation2d;

public class ModuleConstants {

    public static final Rotation2d ANGULAR_TOLERANCE = Rotation2d.fromDegrees(1.8);

    public static final Slot0Configs PIDConfiguration = new Slot0Configs()
            .withKP(45)
            .withKI(0)
            .withKD(0);

    public static double LINEAR_MOTOR_POWER_MULTIPLIER = 0.8;

    public static int LINEAR_MOTOR_ID = 0;
    public static int ANGULAR_MOTOR_ID = 1;
    public static double GEAR_RATIO = 150.0 / 7;
}
