package training.Wrist;

import training.Robot;

public class WristFactory {
    SimulationWrist simulationWrist = new SimulationWrist();
    NeoWrist neoWrist = new NeoWrist();

    public IWrist create() {
        return switch (Robot.getRobotType()) {
            case SIMULATION -> simulationWrist;
            case PREVIOUSLY_SYNCOPA -> neoWrist;
        };
    }
}
