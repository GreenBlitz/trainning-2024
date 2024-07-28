package subsystems.Roller;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel;
import edu.wpi.first.math.controller.ArmFeedforward;

public class Constants {

    static final int ROLLER_MOTOR_ID = 0; // TODO replace with actual value
    static final CANSparkLowLevel.MotorType ROLLER_MOTOR_TYPE = CANSparkLowLevel.MotorType.kBrushless;
    static final CANSparkBase.ControlType ROLLER_CONTROL_TYPE = CANSparkBase.ControlType.kVelocity;

}
