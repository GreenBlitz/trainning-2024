package training.Elbow.NeoElbow;

import com.revrobotics.CANSparkLowLevel;
import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Rotation2d;

public class NeoElbowConstants {
    protected static final int ELBOW_ID = 0;

    protected static final CANSparkLowLevel.MotorType ELBOW_MOTOR_TYPE = CANSparkLowLevel.MotorType.kBrushless;


    protected static final PIDController ELBOW_PID_CONTROLLER = new PIDController(0, 0, 0);

    protected static final ArmFeedforward ELBOW_FEEDFORWARD = new ArmFeedforward(0, 0, 0, 0); // Keep kV and kA 0



    protected static final double ELBOW_GEAR_RATIO = 250/7;

    protected static final double UPPER_POWER_LIMIT_ELBOW = 0.9;
    protected static final double LOWER_POWER_LIMIT_ELBOW = -0.9;


    protected static final int PID_SLOT = 0;
}
