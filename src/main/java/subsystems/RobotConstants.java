package subsystems;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel;

public class RobotConstants {

	public static final int ELBOW_MOTOR_ID = 5;

	public static final CANSparkLowLevel.MotorType ELBOW_MOTOR_BRUSHLESS_TYPE = CANSparkLowLevel.MotorType.kBrushless;

	public static final CANSparkBase.ControlType ELBOW_CONTROL_TYPE = CANSparkBase.ControlType.kPosition;

}
