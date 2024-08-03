package training.Elbow;

import training.Robot;

public class ElbowFactory {
    public IElbow create() {
        return switch (Robot.getRobotType()) {
            case Simulation -> SimulationElbow.getInstance();
            case PREVIOUSLY_SYNCOPA -> NeoElbow.getInstance();
        };
    }
}
