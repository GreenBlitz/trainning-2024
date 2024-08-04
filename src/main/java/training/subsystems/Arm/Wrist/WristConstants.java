package training.subsystems.Arm.Wrist;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
import edu.wpi.first.math.geometry.Rotation2d;

public class WristConstants {
    protected static final int WRIST_ID = 0;

    protected static final double TOLERANCE = 5;

    protected static final Rotation2d WRIST_START_POSITION = Rotation2d.fromDegrees(6);
    protected static final Rotation2d WRIST_CLIMBING_POSITION = Rotation2d.fromDegrees(153);

    protected static final double WRIST_P = 89;
    protected static final double WRIST_I = 76;
    protected static final double WRIST_D = 45;
    protected static final double WRIST_KS = 0;
    protected static final double WRIST_KG = 0.12;
    protected static final double WRIST_KV = 0;
    protected static final double WRIST_KA = 0;

    public static final int PID_SLOT  = 0;

    protected static final int TIMEOUT_FOR_CONFIG_SET = 1;


    protected static final TalonSRXConfiguration TALON_SRX_CONFIG = new TalonSRXConfiguration();

    static {
        TALON_SRX_CONFIG.slot0.kP = WRIST_P;
        TALON_SRX_CONFIG.slot0.kI = WRIST_I;
        TALON_SRX_CONFIG.slot0.kD = WRIST_D;
    }
}
