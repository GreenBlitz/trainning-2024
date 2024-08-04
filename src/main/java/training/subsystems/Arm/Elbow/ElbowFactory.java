package training.subsystems.Arm.Elbow;

import training.RobotConstants;

public class ElbowFactory {
    public static IElbow create(){
        return switch (RobotConstants.ROBOT_TYPE){
            case SIM -> null;
            case REAL -> NeoElbow.getInstance();
        };
    }
}
