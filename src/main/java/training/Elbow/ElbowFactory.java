package training.Elbow;

import training.Robot;
import training.Roller.NeoRoller;

public class ElbowFactory {
    SimulationElbow simulationElbow = new SimulationElbow();
    NeoElbow neoElbow = new NeoElbow();

    public IElbow create() {
        return switch (Robot.getRobotType()) {
            case SIMULATION -> simulationElbow;
            case PREVIOUSLY_SYNCOPA -> neoElbow;
        };
    }
}
