package training.subsystems.Arm.Elbow;
import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.geometry.Rotation2d;

public class ElbowConstants {
    protected static final int ELBOW_ID = 0;

    protected static final double TOLERANCE = 5;

    protected static final Rotation2d ELBOW_START_POSITION = Rotation2d.fromDegrees(0);

    protected static final Rotation2d ELBOW_CLIMBING_POSITION = Rotation2d.fromDegrees(180);

    protected static final ArmFeedforward ARM_FEEDFORWARD = new ArmFeedforward(
            ElbowConstants.ELBOW_KS,
            ElbowConstants.ELBOW_KG,
            ElbowConstants.ELBOW_KV,
            ElbowConstants.ELBOW_KA
    );

    protected static final double ELBOW_P = 89;

    protected static final double ELBOW_I = 76;

    protected static final double ELBOW_D = 45;

    protected static final double ELBOW_KS = 0;

    protected static final double ELBOW_KG = 0.12;

    protected static final double ELBOW_KV = 0;

    protected static final double ELBOW_KA = 0;

    public static final Rotation2d ELBOW_GEAR_RATIO = Rotation2d.fromDegrees(1 / (28.0 * (60.0 / 16.0)));





    public static final int NUMBER_OF_MOTORS = 1;

    public enum PresetPositions {
        SAFE(Rotation2d.fromDegrees(-67)),
        INTAKE(Rotation2d.fromDegrees(-76)),
        SCORE(Rotation2d.fromDegrees(55)),
        STARTING(Rotation2d.fromDegrees(0)),
        TRANSFER(Rotation2d.fromDegrees(-80));

        public final Rotation2d ANGLE;

        PresetPositions(Rotation2d angle) {
            this.ANGLE = angle;
        }
    }

    public static final Rotation2d MINIMUM_ANGLE = Rotation2d.fromDegrees(-82);

    public static final double ARM_LENGTH = 0.44;

    public static final double ARM_DISTANCE_FROM_CENTER = 0.1;

    public static final double ARM_MASS_KG = 0.44;

    public static final Rotation2d BACKWARD_ANGLE_LIMIT = Rotation2d.fromDegrees(-81);

    public static final Rotation2d FORWARD_ANGLE_LIMIT = Rotation2d.fromDegrees(90);


    public static final double GEAR_RATIO = 1 / (28.0 * (60.0 / 16.0));

    public static final int CURRENT_LIMIT = 40;
}
