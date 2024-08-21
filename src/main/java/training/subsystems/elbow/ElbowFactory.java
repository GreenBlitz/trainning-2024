package training.subsystems.elbow;

import training.TrainingRobotManager;
import utils.simulation.SimulationManager;

public class ElbowFactory {
    public static IElbow create() {
        if (TrainingRobotManager.robotType == RobotTypes.SIMULATION) {
            return new ElbowSimulation();
        } else {
            return new ElbowNEO();
        }
    }
}