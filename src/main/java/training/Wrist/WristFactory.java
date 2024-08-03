package training.Wrist;

import training.Robot;

public class WristFactory {
    public IWrist create() {
        return switch (Robot.getRobotType()) {
            case Simulation -> SimulationWrist.getInstance();
            case PREVIOUSLY_SYNCOPA -> NeoWrist.getInstance();
        };
    }
}
