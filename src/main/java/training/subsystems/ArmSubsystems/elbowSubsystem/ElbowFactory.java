package training.subsystems.ArmSubsystems.elbowSubsystem;

import training.Robot;
import training.RobotConstants;
import training.subsystems.ArmSubsystems.elbowSubsystem.neoElbow.NeoElbow;
import training.subsystems.ArmSubsystems.elbowSubsystem.simulationElbow.SimulationElbow;

public class ElbowFactory {

    public static IElbow create() {
        return switch (RobotConstants.ROBOT_TYPE) {
            case SYNCOPA -> NeoElbow.getInstance();
            case SIMULATION -> SimulationElbow.getInstance();
        };
    }
}
