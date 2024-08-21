package training.subsystems.elbow;

import training.TrainingRobotManager;

public class ElbowFactory {

    public static IElbow create() {

        return switch (TrainingRobotManager.ROBOT_TYPE) {
            case SIMULATION -> new ElbowSimulation();
            case SYNKOPA -> new NeoElbow();
        };
    }
}