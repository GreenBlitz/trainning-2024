package training.subsystems.ArmSubsystems;

import edu.wpi.first.math.geometry.Rotation2d;

public class Arm_constants {

    protected static final int ELBOW_ID = 0;
    protected static final int WRIST_ID = 0;
    protected static final int ROLLER_ID = 0;
    protected static final Rotation2d ELBOW_STARTING_POSITION = Rotation2d.fromDegrees(0);
    public static final Rotation2d ELBOW_CLIMBING_POSITION = Rotation2d.fromDegrees(180);
    protected static final Rotation2d WRIST_STARTING_POSITION = Rotation2d.fromDegrees(8);
    public static final Rotation2d WRIST_CLIMBING_POSITION = Rotation2d.fromDegrees(93);
    public static final Rotation2d ELBOW_TOLERANCE = Rotation2d.fromDegrees(5);
    public static final Rotation2d WRIST_TOLERANCE = Rotation2d.fromDegrees(5);

    protected static final double ELBOW_P_VALUE = 5;
    protected static final double ELBOW_I_VALUE = 5;
    protected static final double ELBOW_D_VALUE = 5;

    protected static final double WRIST_P_VALUE = 5;
    protected static final double WRIST_I_VALUE = 5;
    protected static final double WRIST_D_VALUE = 5;



}
