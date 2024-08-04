package training.Roller;

import training.Robot;

public class RollerFactory {
    SimulationRoller simulationRoller = new SimulationRoller();
    NeoRoller neoRoller = new NeoRoller();

    public IRoller create() {
        return switch (Robot.getRobotType()) {
            case SIMULATION -> simulationRoller;
            case PREVIOUSLY_SYNCOPA -> neoRoller;
        };
    }
}
