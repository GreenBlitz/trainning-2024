package training.subsystems.ArmSubsystems.elbowSubsystem;

import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Rotation2d;

public class ElbowConstants {

    public static final int ELBOW_ID = 5;

    public static final Rotation2d ELBOW_STARTING_POSITION = Rotation2d.fromDegrees(-82);
    public static final Rotation2d ELBOW_CLIMBING_POSITION = Rotation2d.fromDegrees(55);

    public static final Rotation2d ELBOW_TOLERANCE_DEGREES = Rotation2d.fromDegrees(5);

    public static final Rotation2d ELBOW_GEAR_RATIO = Rotation2d.fromDegrees(1 / (28.0 * (60.0 / 16.0)));

    public static final double ELBOW_P_VALUE = 10;
    public static final double ELBOW_I_VALUE = 0;
    public static final double ELBOW_D_VALUE = 0;

    public static final PIDController PIDController = new PIDController(
            ElbowConstants.ELBOW_P_VALUE,
            ElbowConstants.ELBOW_I_VALUE,
            ElbowConstants.ELBOW_D_VALUE
    );


    public static final double ELBOW_KS_VALUE = 0;
    public static final double ELBOW_KG_VALUE = 0;
    public static final double ELBOW_KV_VALUE = 0;
    public static final double ELBOW_KA_VALUE = 0;

    public static final ArmFeedforward FEEDFORWARD_CONTROLER = new ArmFeedforward(
            ElbowConstants.ELBOW_KS_VALUE,
            ElbowConstants.ELBOW_KG_VALUE,
            ElbowConstants.ELBOW_KV_VALUE,
            ElbowConstants.ELBOW_KA_VALUE

    );

    public static final double ARM_LENGTH = 0.44;
    public static final double ARM_MASS_KG = 0.44;

    public static final Rotation2d BACKWARD_ANGLE_LIMIT = Rotation2d.fromDegrees(-81);

    public static final Rotation2d FORWARD_ANGLE_LIMIT = Rotation2d.fromDegrees(90);

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


}

