package training.subsystems.Arm;

import edu.wpi.first.math.geometry.Rotation2d;

public class Constants {
    protected static final int ELBOW_ID = 0;
    protected static final int WRIST_ID = 0;
    protected static final int ROLLER_ID = 0;

    protected static final Rotation2d ELBOW_START_POSITION = Rotation2d.fromDegrees(0);
    protected static final Rotation2d ELBOW_CLIMBING_POSITION = Rotation2d.fromDegrees(180);

    protected static final Rotation2d WRIST_START_POSITION = Rotation2d.fromDegrees(6);
    protected static final Rotation2d WRIST_CLIMBING_POSITION = Rotation2d.fromDegrees(153);

    protected static final double ELBOW_P = 89;
    protected static final double ELBOW_I = 76;
    protected static final double ELBOW_D = 45;
}
