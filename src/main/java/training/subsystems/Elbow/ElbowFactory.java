package training.subsystems.Elbow;

import training.subsystems.Elbow.NeoElbow.NeoElbow;
import training.subsystems.Elbow.SimulationElbow.SimulationElbow;

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
