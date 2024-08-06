package training.Wrist.NeoWrist;

import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;

public class WristConstants {

	protected static final double POWER_LIMIT_WRIST = 0.9; // limit both min and max

	protected static final TalonSRXConfiguration WRIST_PID_CONFIG = new TalonSRXConfiguration();

	static {
		WRIST_PID_CONFIG.slot0.kP = 0;
		WRIST_PID_CONFIG.slot0.kI = 0;
		WRIST_PID_CONFIG.slot0.kD = 0;
	}

	protected static final int WRIST_ID = 4;


}
