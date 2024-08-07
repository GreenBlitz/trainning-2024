package training.Roller.NeoRoller;

import com.revrobotics.CANSparkLowLevel;

public class NeoRollerConstants {


	protected static final int ID = 22;

	protected static final CANSparkLowLevel.MotorType MOTOR_TYPE = CANSparkLowLevel.MotorType.kBrushless;

	protected static final double GEAR_RATIO = 1;

	protected static final double KP = 0;

	protected static final double KI = 0;

	protected static final double KD = 0;

	protected static final double POWER_LIMIT = 0.9; // ! overwrites PID

}
