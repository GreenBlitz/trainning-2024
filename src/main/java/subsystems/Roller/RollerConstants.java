package subsystems.Roller;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel;
public class RollerConstants {

    protected static final int ROLLER_MOTOR_ID = 22;

    protected static final CANSparkLowLevel.MotorType ROLLER_MOTOR_BRUSHLESS_TYPE = CANSparkLowLevel.MotorType.kBrushless;

    protected static final CANSparkBase.ControlType ROLLER_CONTROL_TYPE = CANSparkBase.ControlType.kVelocity;

}
