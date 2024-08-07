package training.subsystems.ArmSubsystems.wrist;

import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
import edu.wpi.first.math.geometry.Rotation2d;

public class WristConstants {

	protected static final int ID = 11;

	public static final Rotation2d STARTING_POSITION = Rotation2d.fromDegrees(90);
	public static final Rotation2d CLIMBING_POSITION = Rotation2d.fromDegrees(390);

	public static final Rotation2d TOLERANCE = Rotation2d.fromDegrees(5);

	public static final int PID_SLOT = 0;

	public static final double MAG_ENCODER_CONVERSION_FACTOR = 8192;


	protected static final double P_VALUE = 0.4;
	protected static final double I_VALUE = 0;
	protected static final double D_VALUE = 0;

	protected static final double KS_VALUE = 0;
	protected static final double KG_VALUE = 0;
	protected static final double KV_VALUE = 0;
	protected static final double KA_VALUE = 0;

	protected static final int TIMEOUT_FOR_CONFIG_SET = 1;


	protected static final TalonSRXConfiguration TALON_SRX_CONFIG = new TalonSRXConfiguration();

	static {
		TALON_SRX_CONFIG.slot0.kP = P_VALUE;
		TALON_SRX_CONFIG.slot0.kI = I_VALUE;
		TALON_SRX_CONFIG.slot0.kD = D_VALUE;
	}

}
