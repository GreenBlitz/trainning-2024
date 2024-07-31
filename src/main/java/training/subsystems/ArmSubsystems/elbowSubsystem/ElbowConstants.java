package training.subsystems.ArmSubsystems.elbowSubsystem;

import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.geometry.Rotation2d;

public class ElbowConstants {

    protected static final int ELBOW_ID = 0;

    public static final Rotation2d ELBOW_STARTING_POSITION = Rotation2d.fromDegrees(0);
    public static final Rotation2d ELBOW_CLIMBING_POSITION = Rotation2d.fromDegrees(55);

    public static final Rotation2d ELBOW_TOLERANCE_DEGREES = Rotation2d.fromDegrees(5);

    protected static final double ELBOW_P_VALUE = 1;
    protected static final double ELBOW_I_VALUE = 0;
    protected static final double ELBOW_D_VALUE = 0;

    protected static final double ELBOW_KS_VALUE = 0;
    protected static final double ELBOW_KG_VALUE = 0;
    protected static final double ELBOW_KV_VALUE = 0;
    protected static final double ELBOW_KA_VALUE = 0;

    protected static final ArmFeedforward ARM_FEEDFORWARD = new ArmFeedforward(
            ElbowConstants.ELBOW_KS_VALUE,
            ElbowConstants.ELBOW_KG_VALUE,
            ElbowConstants.ELBOW_KV_VALUE,
            ElbowConstants.ELBOW_KA_VALUE
    );
}
