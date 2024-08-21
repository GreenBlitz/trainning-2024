package training;

import com.ctre.phoenix6.configs.Slot0Configs;
import edu.wpi.first.math.geometry.Rotation2d;

public class ModuleConstants {

    public static final Rotation2d ANGULAR_TOLERANCE = Rotation2d.fromDegrees(1.8);

    public static final Slot0Configs PIDConfiguration = new Slot0Configs()
            .withKP(45)
            .withKI(0)
            .withKD(0);

}
