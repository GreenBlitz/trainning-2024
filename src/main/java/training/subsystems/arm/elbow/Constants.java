package training.subsystems.arm.elbow;


import com.pathplanner.lib.util.PIDConstants;
import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.geometry.Rotation2d;

class Constants {
    
    static int MOTOR_ID = 1;
    
    static Rotation2d TOLERANCE = Rotation2d.fromDegrees(10);
    
    static final double GEAR_RATIO = 1;
    
    static final double KP = 0;
    
    static final double KI = 0;
    
    static final double KD = 0;
    
    static final double KG = 0;
    
    static final double KS = 0;
    
    static final double KV = 0;
    
    static final  double BATTERY_VOLTAGE = 12;
    static final ArmFeedforward ELBOW_FEEDFORWARD = new ArmFeedforward(KG, KS, KV);

}