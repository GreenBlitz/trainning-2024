package training;

import com.ctre.phoenix6.configs.Slot0Configs;
import edu.wpi.first.math.geometry.Rotation2d;

public class ModuleConstants {
    public static final Rotation2d ANGULAR_TOLERANCE = Rotation2d.fromDegrees(1.8);
    public static final Slot0Configs ANGULAR_MOTOR_SLOT0_CONFIGS = new Slot0Configs()
            .withKP(85)
            .withKI(0)
            .withKD(1);
    public static final int LINEAR_MOTOR_ID = 0;
    public static final int ANGULAR_MOTOR_ID = 1;
    public static final double GEAR_RATIO = 150.0 / 7;
}