package training.subsystems.ArmSubsystems.wrist.talonWrist;

import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
import edu.wpi.first.math.controller.PIDController;
import training.subsystems.ArmSubsystems.wrist.WristConstants;

public class TalonWristConstants {

	protected static final int ID = 11;

	public static final int PID_SLOT = 0;

	public static final double GEAR_RATIO = 1 / WristConstants.CONVERSION_FACTOR;

	protected static final double KP = 0.4;
	protected static final double KI = 0;
	protected static final double KD = 0;

	protected static final PIDController PID_CONTROLLER = new PIDController(KP, KI, KD);

	protected static final double KS = 0;
	protected static final double KG = 0;
	protected static final double KV = 0;
	protected static final double KA = 0;

	protected static final TalonSRXConfiguration TALON_SRX_CONFIG = new TalonSRXConfiguration();

	static {
		TALON_SRX_CONFIG.slot0.kP = KP;
		TALON_SRX_CONFIG.slot0.kI = KI;
		TALON_SRX_CONFIG.slot0.kD = KD;
	}

}
