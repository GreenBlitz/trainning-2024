package training.Elbow;

import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Rotation2d;

public class ElbowConstants {
    //* These constants are temp and shall be replaced with calibrated constants that aren't 0
    public static final String ELBOW_LOG_PATH = "";
    public static final Rotation2d DEFAULT_POSITION_ELBOW = new Rotation2d(1, 1);

    public static final PIDController ELBOW_PID_CONTROLLER = new PIDController(0, 0, 0);
    public static final ArmFeedforward ELBOW_FEEDFORWARD = new ArmFeedforward(0, 0, 0, 0); // Keep kV and kA 0
    public static final Rotation2d ELBOW_TOLERANCE = new Rotation2d(0);
    public static final double ELBOW_GEAR_RATIO = 250/7;
    public static final int ELBOW_ID = 0;
    public static final double POWER_LIMIT_ELBOW = 0.9;

    public static final double DEFAULT_LIFT_DEG = 30;

    public static final Rotation2d SCORE_POSITION = new Rotation2d(0, 0);
    public static final Rotation2d PICKUP_POSITION = new Rotation2d(0, 0);
}
