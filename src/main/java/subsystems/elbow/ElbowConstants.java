package subsystems.elbow;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel;
import edu.wpi.first.math.controller.ArmFeedforward;

public class ElbowConstants {

    protected static final int ELBOW_MOTOR_ID = 5;
    protected static final CANSparkLowLevel.MotorType ELBOW_MOTOR_BRUSHLESS_TYPE = CANSparkLowLevel.MotorType.kBrushless;
    protected static final CANSparkBase.ControlType ELBOW_CONTROL_TYPE = CANSparkBase.ControlType.kPosition;
    protected static final int SINGLE_ROTATION = 1;
    protected static final ArmFeedforward ELBOW_FEED_FORWARD = new ArmFeedforward(0, 0, 0); // TODO replace with useful FF values
    protected static final int WRIST_PID_SLOT = 0;


}
