package training.Wrist;

import training.Robot;

public class WristFactory {
    public IWrist create() {
        return switch (Robot.getRobotType()) {
            case SIMULATION -> new SimulationWrist();
            case SYNCOPA -> new NeoWrist();
        };
    }

}
