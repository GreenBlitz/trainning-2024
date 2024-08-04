package training.Roller;

import com.revrobotics.CANSparkLowLevel;
import edu.wpi.first.math.controller.PIDController;

public class RollerConstants {

    //* These constants are temp and shall be replaced with calibrated constants that aren't 0
    protected static final double ROLLER_ROLLING_TIME_SECONDS = 0.5;

    protected static final String ROLLER_LOG_PATH = "";

    protected static final int ROLLER_ID = 22;

    protected static final CANSparkLowLevel.MotorType ROLLER_MOTOR_TYPE = CANSparkLowLevel.MotorType.kBrushless;

    protected static final double ROLLER_GEAR_RATIO = 1;

    protected static final double ROLLER_DEFAULT_VELOCITY_RPM = 0;

    protected static final double ROLLER_P = 0;

    protected static final double ROLLER_I = 0;

    protected static final double ROLLER_D = 0;

    protected static final double POWER_LIMIT_ROLLER = 0.9; //! overwrites PID

    //* Simulation
    protected static final double ROLLER_GEARING = 0;

    protected static final double POWER_TO_ACCELERATION = 0;

    protected static PIDController ROLLER_SIMULATION_CONTROLLER = new PIDController(0, 0, 0);

}
