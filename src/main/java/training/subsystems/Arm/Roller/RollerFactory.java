package training.subsystems.Arm.Roller;

import training.Robot;
import training.subsystems.Arm.Elbow.SimulationElbow.SimulationElbow;
import training.subsystems.Arm.Roller.NeoRoller.NeoRoller;
import training.subsystems.Arm.Roller.SimulationRoller.SimulationRoller;

public class RollerFactory {
    public static IRoller create() {
        IRoller roller;
        switch (Robot.ROBOT_TYPE) {
            case SYNCOPA -> {
                roller = new NeoRoller();
            }
            case SIMULATION -> {
                roller = new SimulationRoller();
            }
            default -> {
                roller = null;
            }
        }
        return roller;
    }
}
