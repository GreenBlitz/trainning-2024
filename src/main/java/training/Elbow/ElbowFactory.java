package training.Elbow;

import training.Robot;

public class ElbowFactory {
    public IElbow create() {
        return switch (Robot.getRobotType()) {
            case SIMULATION -> new SimulationElbow();
            case SYNCOPA -> new BrokenNeoElbow();
        };
    }

}
