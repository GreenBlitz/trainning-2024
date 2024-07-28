package training.Roller;

public class RollerConstants {
    //* These constants are temp and shall be replaced with calibrated constants that aren't 0
    public static final double ROLLER_ROLLING_TIME_SEC = 0.5;

    public static final String ROLLER_LOG_PATH = "";
    public static final int ROLLER_ID = 0;

    public static final double ROLLER_GEAR_RATIO = 1;
    public static final double ROLLER_DEFAULT_VELOCITY_RPM = 0;
    public static final double VELOCITY_LIMIT_ROLLER = 0.8;
    public static final double ROLLER_P = 0;
    public static final double ROLLER_I = 0;
    public static final double ROLLER_D = 0;
    public static final double POWER_LIMIT_ROLLER = 0.9; //! overwrites PID

    //TODO: implement feedforward

}
