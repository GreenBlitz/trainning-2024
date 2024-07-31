package subsystems.Roller;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel;
public class RollerConstants {
    static final int ROLLER_MOTOR_ID = 22;
    static final CANSparkLowLevel.MotorType ROLLER_MOTOR_BRUSHLESS_TYPE = CANSparkLowLevel.MotorType.kBrushless;
    static final CANSparkBase.ControlType ROLLER_CONTROL_TYPE = CANSparkBase.ControlType.kVelocity;

}
