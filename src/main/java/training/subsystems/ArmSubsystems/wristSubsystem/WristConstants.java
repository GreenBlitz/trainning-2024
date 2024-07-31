package training.subsystems.ArmSubsystems.wristSubsystem;

import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
import edu.wpi.first.math.geometry.Rotation2d;

public class WristConstants {

    protected static final int WRIST_ID = 0;

    public static final Rotation2d WRIST_STARTING_POSITION = Rotation2d.fromDegrees(8);
    public static final Rotation2d WRIST_CLIMBING_POSITION = Rotation2d.fromDegrees(93);

    public static final Rotation2d WRIST_TOLERANCE_DEGREES = Rotation2d.fromDegrees(5);

    protected static final double WRIST_P_VALUE = 1;
    protected static final double WRIST_I_VALUE = 0;
    protected static final double WRIST_D_VALUE = 0;

    protected static final double WRIST_KS_VALUE = 0;
    protected static final double WRIST_KG_VALUE = 0;
    protected static final double WRIST_KV_VALUE = 0;
    protected static final double WRIST_KA_VALUE = 0;

    protected static final TalonSRXConfiguration SRX_CONFIG = new TalonSRXConfiguration();

    static {
        SRX_CONFIG.slot0.kP = WRIST_P_VALUE;
        SRX_CONFIG.slot0.kI = WRIST_I_VALUE;
        SRX_CONFIG.slot0.kD = WRIST_D_VALUE;
    }

}
