package training.subsystems.Elbow;

import edu.wpi.first.math.controller.ElevatorFeedforward;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Rotation2d;

public class ElbowConstants {
    //* These constants are temp and shall be replaced with calibrated constants that aren't 0
    static final String ELBOW_LOG_PATH = "";
    static final Rotation2d DEFAULT_POSITION_ELBOW = new Rotation2d(1, 1);

    static final PIDController ELBOW_PID_CONTROLLER = new PIDController(0, 0, 0);
    static final ElevatorFeedforward ELBOW_FEEDFORWARD = new ElevatorFeedforward(0, 0, 0, 0);
    static final double ELBOW_TOLERANCE = 0;
    static final double ELBOW_GEAR_RATIO = 250/7;
    static final int ELBOW_ID = 0;
    static final double POWER_LIMIT_ELBOW = 0.9;
}
