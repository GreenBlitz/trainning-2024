package training.subsystems.Arm.Elbow;

import training.subsystems.Arm.Elbow.NeoElbow.NeoElbow;
import training.subsystems.Arm.Elbow.SimulationElbow.SimulationElbow;

public class ElbowFactory {
    public static IElbow create() {
        IElbow elbow;
        switch (ElbowConstants.ROBOT_TYPE) {
            case SYNCOPA -> {
                elbow = new NeoElbow();
            }
            case SIMULATION -> {
                elbow = new SimulationElbow();
            }
            default -> {
                elbow = null;
            }
        }
        return elbow;
    }
}
