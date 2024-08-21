package training.subsystems.Arm.Roller;

import training.Robot;
import training.subsystems.Arm.Elbow.SimulationElbow.SimulationElbow;
import training.subsystems.Arm.Roller.NeoRoller.NeoRoller;
import training.subsystems.Arm.Roller.SimulationRoller.SimulationRoller;

public class RollerFactory {

    public static IRoller create() {
        return switch (Robot.ROBOT_TYPE) {
            case SYNCOPA ->  new NeoRoller();
            case SIMULATION -> new SimulationRoller();
        };
    }
}
