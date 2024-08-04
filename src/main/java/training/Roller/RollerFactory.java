package training.Roller;

import training.Robot;

public class RollerFactory {
    public IRoller create() {
        return switch (Robot.getRobotType()) {
            case SIMULATION -> new SimulationRoller();
            case PREVIOUSLY_SYNCOPA -> new NeoRoller();
        };
    }

}
