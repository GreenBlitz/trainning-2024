package training.Wrist.NeoWrist;

import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;

public class WristConstants {

	protected static final double POWER_LIMIT = 0.9; // limit both min and max

	protected static final TalonSRXConfiguration PID_CONFIG = new TalonSRXConfiguration();

	static {
		PID_CONFIG.slot0.kP = 0;
		PID_CONFIG.slot0.kI = 0;
		PID_CONFIG.slot0.kD = 0;
	}

	protected static final int ID = 4;

}
