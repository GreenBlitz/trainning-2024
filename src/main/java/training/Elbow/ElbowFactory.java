package training.Elbow;

import training.Robot;
import training.Roller.NeoRoller;

public class ElbowFactory {
    SimulationElbow simulationElbow = new SimulationElbow();
    NeoRoller neoRoller = new NeoRoller();

    public IElbow create() {
        return switch (Robot.getRobotType()) {
            case SIMULATION -> simulationElbow;
            case PREVIOUSLY_SYNCOPA -> neoRoller;
        };
    }
}
