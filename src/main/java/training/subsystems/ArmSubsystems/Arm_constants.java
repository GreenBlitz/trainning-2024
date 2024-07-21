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


}
