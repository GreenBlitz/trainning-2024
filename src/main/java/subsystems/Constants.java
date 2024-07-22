package subsystems;

import edu.wpi.first.math.geometry.Rotation2d;

public class Constants {
    //* This constants are temp and shall be replaced with calibrated constants that aren't 0

    static final double MAX_ANGLE = 0.5 * Math.PI;
    static final int ELBOW_ID = 0;
    static final int ROLLER_ID = 0;
    static final int WRIST_ID = 0;

    static final double MAX_POWER_WRIST = 0.9; // limit both min and max
    static final int PEAK_DURATION_WRIST_MS = 10; //! CHECK THIS BEFORE RUNNING. Better slow than sorry (killing the motor/battery)
    static final int CONTINUES_MAX_CURRENT_AMP = 0;
    static final int PEAK_MAX_CURRENT_AMP = 0;
    static final double WRIST_TRAVEL_TIME = 0;

    static final Rotation2d DEFAULT_POSITION_ELBOW = new Rotation2d(1, 1);
    static final double ELBOW_P = 0;
    static final double ELBOW_I = 0;
    static final double ELBOW_D = 0;

    static final double ROLLER_P = 0;
    static final double ROLLER_I = 0;
    static final double ROLLER_D = 0;

    //TODO: implement feetforward

}
