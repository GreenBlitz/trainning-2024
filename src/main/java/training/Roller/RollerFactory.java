package training.Roller;

import training.Elbow.IElbow;
import training.Elbow.NeoElbow;
import training.Elbow.SimulationElbow;
import training.Robot;

public class RollerFactory {
    public IRoller create() {
        return switch (Robot.getRobotType()) {
            case Simulation -> SimulationRoller.getInstance();
            case PREVIOUSLY_SYNCOPA -> NeoRoller.getInstance();
        };
    }
}
