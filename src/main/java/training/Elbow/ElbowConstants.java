package training.Elbow;

import com.revrobotics.CANSparkLowLevel;
import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.system.plant.DCMotor;

public class ElbowConstants {

    //* These constants are temp and shall be replaced with calibrated constants that aren't 0

    protected static final String ELBOW_LOG_PATH = "";

    protected static final int ELBOW_ID = 0;

    protected static final CANSparkLowLevel.MotorType ELBOW_MOTOR_TYPE = CANSparkLowLevel.MotorType.kBrushless;


    protected static final PIDController ELBOW_PID_CONTROLLER = new PIDController(0, 0, 0);

    protected static final ArmFeedforward ELBOW_FEEDFORWARD = new ArmFeedforward(0, 0, 0, 0); // Keep kV and kA 0

    protected static final Rotation2d ELBOW_TOLERANCE = new Rotation2d(0);


    protected static final double ELBOW_GEAR_RATIO = 250/7;

    protected static final double POWER_LIMIT_ELBOW = 0.9;


    protected static final double DEFAULT_TIME_IN_AIR_ELBOW_SECONDS = 0.1;


    protected static final Rotation2d LIFTING_POSITION_DEGREES = Rotation2d.fromDegrees(30);


    public static final Rotation2d DEFAULT_POSITION_ELBOW = new Rotation2d(1, 1);

    public static final Rotation2d SCORE_POSITION_ELBOW = new Rotation2d(0, 0);

    public static final Rotation2d PICKUP_POSITION_ELBOW = new Rotation2d(0, 0);


    protected static final int PID_SLOT = 0;


    // * Simulation

    protected static double PLANT;

    protected static DCMotor ELBOW_GEARBOX = new DCMotor(0, 0, 0, 0, 0, 0);

    protected static double ELBOW_GEARING = 0;

    protected static double ELBOW_LENGTH_METERS = 0;

    protected static double ELBOW_MASS = 0;

    protected static Rotation2d ELBOW_MINIMUM_ANGLE = Rotation2d.fromRotations(0);

    protected static Rotation2d ELBOW_MAXIMUM_ANGLE = Rotation2d.fromRotations(0);

    protected static Rotation2d ELBOW_TOLERANCE_SIM = Rotation2d.fromRotations(0);

    protected static PIDController Controller = new PIDController(0, 0, 0); // Outputs power

}
