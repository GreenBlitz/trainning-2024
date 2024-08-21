package training.subsystems.RobotArm.wrist;

import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;

public class WristConstans {

	public static final double KP = 20, KI = 0, KD = 0, KS = 0, KA = 0, KV = 0, KG = 0, ARB_FEED_FOWORDS = 0,
		MAG_ENCODER_CONVERSION_FACTOR = 8192;
	public static final int MOTOR_ID = 0, PID_SLOT = 0, TIME_OUT_FOR_CONFIGS_SET = 0;
	public static final TalonSRXConfiguration TALON_SRX_CONFIGURATION = new TalonSRXConfiguration();

	static {
		TALON_SRX_CONFIGURATION.slot0.kP = KP;
		TALON_SRX_CONFIGURATION.slot0.kI = KI;
		TALON_SRX_CONFIGURATION.slot0.kD = KD;
	}

}
