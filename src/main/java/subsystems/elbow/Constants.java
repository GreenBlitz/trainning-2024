package subsystems.elbow;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;

public class Constants {

    static final int ELBOW_MOTOR_ID = 0; // TODO replace with actual value
    static final CANSparkLowLevel.MotorType ELBOW_MOTOR_TYPE = CANSparkLowLevel.MotorType.kBrushless;
    static final CANSparkBase.ControlType ELBOW_CONTORL_TYPE = CANSparkBase.ControlType.kPosition;

}
