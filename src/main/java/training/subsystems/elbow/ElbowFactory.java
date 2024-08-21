package training.subsystems.elbow;

import training.TrainingRobotManager;
import utils.simulation.SimulationManager;

public class ElbowFactory {

    public static IElbow create() {

        return switch (TrainingRobotManager.ROBOT_TYPE) {
            case SIMULATION -> new ElbowSimulation();
            case SYNKOPA -> new ElbowNEO();
        };
    }
}