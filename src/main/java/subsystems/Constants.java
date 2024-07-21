package subsystems;

import edu.wpi.first.math.geometry.Rotation2d;

public class Constants {
    public static final double MAX_ANGLE = 0.5 * Math.PI;
    public static final int ELBOW_ID = 0;
    public static final int WRIST_ID = 0;
    public static final double MAX_POWER_CIM = 0.9; // limit both min and max
    public static final Rotation2d DEFAULT_POSITION = new Rotation2d(1, 1);
}
