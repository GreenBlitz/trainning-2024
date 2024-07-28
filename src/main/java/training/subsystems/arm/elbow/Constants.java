package training.subsystems.arm.elbow;


import com.pathplanner.lib.util.PIDConstants;
import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.geometry.Rotation2d;

class Constants {
    static int MOTOR_ID = 1;
    static Rotation2d TOLERANCE = Rotation2d.fromDegrees(10);
    static double GEAR_RATIO = 1;
    static double P = 0;
    static double I = 0;
    static double D = 0;
    static double KG = 0;
    static double KS = 0;
    static double KV = 0;
    static ArmFeedforward ELBOW_FEEDFORWARD = new ArmFeedforward(KG, KS, KV);
}