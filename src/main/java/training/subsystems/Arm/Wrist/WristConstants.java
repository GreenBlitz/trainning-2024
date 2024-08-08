package training.subsystems.Arm.Wrist;

import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
import edu.wpi.first.math.geometry.Rotation2d;

public class WristConstants {

	protected static final int MOTOR_ID = 0;

	protected static final double TOLERANCE = 5;

	protected static final Rotation2d WRIST_START_POSITION = Rotation2d.fromDegrees(6);

	protected static final Rotation2d WRIST_CLIMBING_POSITION = Rotation2d.fromDegrees(153);

	protected static final double P = 0;

	protected static final double I = 0;

	protected static final double D = 0;

	protected static final double KS = 0;

	protected static final double KG = 0.12;

	protected static final double KV = 0;

	protected static final double KA = 0;

	public static final int PID_SLOT = 0;

	protected static final int TIMEOUT_FOR_CONFIG_SET = 1;


	protected static final TalonSRXConfiguration TALON_SRX_CONFIG = new TalonSRXConfiguration();

	static {
		TALON_SRX_CONFIG.slot0.kP = P;
		TALON_SRX_CONFIG.slot0.kI = I;
		TALON_SRX_CONFIG.slot0.kD = D;
	}

}
