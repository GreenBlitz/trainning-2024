package training.Elbow;

import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Rotation2d;

public class ElbowConstants {
    //* These constants are temp and shall be replaced with calibrated constants that aren't 0
    protected static final String ELBOW_LOG_PATH = "";
    protected static final Rotation2d DEFAULT_POSITION_ELBOW = new Rotation2d(1, 1);

    protected static final PIDController ELBOW_PID_CONTROLLER = new PIDController(0, 0, 0);
    protected static final ArmFeedforward ELBOW_FEEDFORWARD = new ArmFeedforward(0, 0, 0, 0); // Keep kV and kA 0
    protected static final Rotation2d ELBOW_TOLERANCE = new Rotation2d(0);
    protected static final double ELBOW_GEAR_RATIO = 250/7;
    protected static final int ELBOW_ID = 0;
    protected static final double POWER_LIMIT_ELBOW = 0.9;

    protected static final Rotation2d DEFAULT_LIFT_DEG = Rotation2d.fromDegrees(30);

    protected static final Rotation2d SCORE_POSITION = new Rotation2d(0, 0);
    protected static final Rotation2d PICKUP_POSITION = new Rotation2d(0, 0);
}
