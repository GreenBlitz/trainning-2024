package training.subsystems.RobotArm.elbow;

import training.GeneralConstants;
import training.RobotTypes;

public class ElbowFactory {

    public static IElbow create() {
        if (GeneralConstants.robotTypes== RobotTypes.SIMULATION){
            return new ElbowSimulation();
        }

        else {
            return new ElbowNEO();
        }
    }
}
