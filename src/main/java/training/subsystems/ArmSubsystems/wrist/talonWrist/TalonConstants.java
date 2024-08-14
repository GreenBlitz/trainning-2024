package training.subsystems.ArmSubsystems.wrist.talonWrist;

import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
import edu.wpi.first.math.controller.PIDController;
import training.subsystems.ArmSubsystems.wrist.WristConstants;

public class TalonConstants {

	protected static final int ID = 11;

	public static final int PID_SLOT = 0;

	public static final double GEAR_RATIO = 1 / WristConstants.CONVERSION_FACTOR;

	protected static final double P_VALUE = 0.4;
	protected static final double I_VALUE = 0;
	protected static final double D_VALUE = 0;

	protected static final PIDController PID_CONTROLLER = new PIDController(P_VALUE, I_VALUE, D_VALUE);

	protected static final double KS_VALUE = 0;
	protected static final double KG_VALUE = 0;
	protected static final double KV_VALUE = 0;
	protected static final double KA_VALUE = 0;

	protected static final TalonSRXConfiguration TALON_SRX_CONFIG = new TalonSRXConfiguration();

	static {
		TALON_SRX_CONFIG.slot0.kP = P_VALUE;
		TALON_SRX_CONFIG.slot0.kI = I_VALUE;
		TALON_SRX_CONFIG.slot0.kD = D_VALUE;
	}

}
