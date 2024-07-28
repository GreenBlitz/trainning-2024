package training.Wrist;

import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
import edu.wpi.first.math.geometry.Rotation2d;

public class WristConstants {
    //* These constants are temp and shall be replaced with calibrated constants that aren't 0
    public static final String WRIST_LOG_PATH = "";
    public static final int WRIST_ID = 0;

    public static final double POWER_LIMIT_WRIST = 0.9; // limit both min and max
    public static final TalonSRXConfiguration WRIST_PID_CONFIG= new TalonSRXConfiguration();

    static {
        WRIST_PID_CONFIG.slot0.kP = 0;
        WRIST_PID_CONFIG.slot0.kI = 0;
        WRIST_PID_CONFIG.slot0.kD = 0;
    }

    public static final Rotation2d WRIST_UPPER_POSITION = new Rotation2d(0);
    public static final Rotation2d WRIST_LOWER_POSITION = new Rotation2d(0);
}
