package robot.subsystems;

import edu.wpi.first.math.geometry.Rotation2d;

public class Constants {
    //* This constants are temp and shall be replaced with calibrated constants that aren't 0

    static final String LOGPATH = "";

    static final double MAX_ANGLE = 0.5 * Math.PI;
    static final int ELBOW_ID = 0;
    static final int ROLLER_ID = 0;
    static final int WRIST_ID = 0;

    static final double POWER_LIMIT_WRIST = 0.9; // limit both min and max
    static final int PEAK_DURATION_WRIST_MS = 10; // time for PEAK_MAX_CURRENT_AMP to take effect before using the continues val
    static final int CONTINUES_MAX_CURRENT_AMP = 0;
    static final int PEAK_MAX_CURRENT_AMP = 0;

    static final Rotation2d DEFAULT_POSITION_ELBOW = new Rotation2d(1, 1);
    static final double ELBOW_P = 0;
    static final double ELBOW_I = 0;
    static final double ELBOW_D = 0;
    static final double ELBOW_FEEDFORWARD = 0;
    static final double ELBOW_INTEGRAL_EFFECT_ZONE = 0;
    static final double POWER_LIMIT_ELBOW = 0.9; //! overwrites PID
    static final double ELBOW_TOLERANCE = 0;

    static final double ROLLER_DEFAULT_VELOCITY = 0;
    static final double VELOCITY_LIMIT_ROLLER = 0.8;
    static final double ROLLER_P = 0;
    static final double ROLLER_I = 0;
    static final double ROLLER_D = 0;
    static final double POWER_LIMIT_ROLLER = 0.9; //! overwrites PID

    //TODO: implement feetforward

}
