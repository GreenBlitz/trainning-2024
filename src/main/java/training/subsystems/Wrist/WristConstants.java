package training.subsystems.Wrist;

public class WristConstants {
    //* These constants are temp and shall be replaced with calibrated constants that aren't 0
    static final String WRIST_LOGPATH = "";
    static final int WRIST_ID = 0;

    static final double POWER_LIMIT_WRIST = 0.9; // limit both min and max
    static final int PEAK_DURATION_WRIST_MS = 10; // time for PEAK_MAX_CURRENT_AMP to take effect before using the continues val
    static final int CONTINUES_MAX_CURRENT_WRIST_AMP = 0;
    static final int PEAK_MAX_CURRENT_WRIST_AMP = 0;
}
