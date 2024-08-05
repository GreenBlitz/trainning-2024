package training.Roller.NeoRoller;

import com.revrobotics.CANSparkLowLevel;

public class NeoRollerConstants {


    protected static final int ROLLER_ID = 22;

    protected static final CANSparkLowLevel.MotorType ROLLER_MOTOR_TYPE = CANSparkLowLevel.MotorType.kBrushless;

    protected static final double ROLLER_GEAR_RATIO = 1;

    protected static final double ROLLER_P = 0;

    protected static final double ROLLER_I = 0;

    protected static final double ROLLER_D = 0;

    protected static final double POWER_LIMIT_ROLLER = 0.9; //! overwrites PID

}
