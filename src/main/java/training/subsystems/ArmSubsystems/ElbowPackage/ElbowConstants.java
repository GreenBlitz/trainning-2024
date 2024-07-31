package training.subsystems.ArmSubsystems.ElbowPackage;

import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.geometry.Rotation2d;
import training.subsystems.ArmSubsystems.WristPackage.WristConstants;

public class ElbowConstants {

    protected static final int ELBOW_ID = 0;

    protected static final Rotation2d ELBOW_STARTING_POSITION = Rotation2d.fromDegrees(0);
    public static final Rotation2d ELBOW_CLIMBING_POSITION = Rotation2d.fromDegrees(180);

    public static final Rotation2d ELBOW_TOLERANCE_DEGREES = Rotation2d.fromDegrees(5);

    protected static final double ELBOW_P_VALUE = 1;
    protected static final double ELBOW_I_VALUE = 0;
    protected static final double ELBOW_D_VALUE = 0;

    protected static final double ELBOW_KS_VALUE = 0;
    protected static final double ELBOW_KG_VALUE = 0;
    protected static final double ELBOW_KV_VALUE = 0;
    protected static final double ELBOW_KA_VALUE = 0;

    protected static final ArmFeedforward armFeedforward =new ArmFeedforward(
            WristConstants.WRIST_KS_VALUE,
            WristConstants.WRIST_KG_VALUE,
            WristConstants.WRIST_KV_VALUE,
            WristConstants.WRIST_KA_VALUE);
}
