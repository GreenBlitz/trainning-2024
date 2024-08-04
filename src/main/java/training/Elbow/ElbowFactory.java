package training.Elbow;

import training.Robot;
import training.Roller.NeoRoller;

public class ElbowFactory {
    public IElbow create() {
        return switch (Robot.getRobotType()) {
            case SIMULATION -> new SimulationElbow();
            case PREVIOUSLY_SYNCOPA -> new NeoElbow();
        };
    }

}
