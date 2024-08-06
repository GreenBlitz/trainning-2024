package training.Elbow;

import com.revrobotics.CANSparkLowLevel;
import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.system.plant.DCMotor;

public class ElbowConstants {

    //* These constants are temp and shall be replaced with calibrated constants that aren't 0

    protected static final String ELBOW_LOG_PATH = "";


    public static final Rotation2d DEFAULT_POSITION_ELBOW = new Rotation2d(1, 1);

    public static final Rotation2d SCORE_POSITION_ELBOW = new Rotation2d(0, 0);

    public static final Rotation2d PICKUP_POSITION_ELBOW = new Rotation2d(0, 0);


    protected static final double DEFAULT_TIME_IN_AIR_ELBOW_SECONDS = 0.1;


    protected static final Rotation2d LIFTING_POSITION_DEGREES = Rotation2d.fromDegrees(30);

    protected static final Rotation2d ELBOW_TOLERANCE = new Rotation2d(0);


}
