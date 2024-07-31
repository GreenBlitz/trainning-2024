package subsystems.elbow;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel;
import edu.wpi.first.math.controller.ArmFeedforward;

public class ElbowConstants {

    static final int ELBOW_MOTOR_ID = 5;
    static final CANSparkLowLevel.MotorType ELBOW_MOTOR_BRUSHLESS_TYPE = CANSparkLowLevel.MotorType.kBrushless;
    static final CANSparkBase.ControlType ELBOW_CONTROL_TYPE = CANSparkBase.ControlType.kPosition;
    static final int SINGLE_ROTATION = 1;
    static final ArmFeedforward ELBOW_FEED_FORWARD = new ArmFeedforward(0, 0, 0); // TODO replace with useful FF values
    static final int WRIST_PID_SLOT = 0;


}
