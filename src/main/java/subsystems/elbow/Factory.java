package subsystems.elbow;

import subsystems.elbow.neoElbow.NeoElbow;
import subsystems.elbow.simulationElbow.SimulationElbow;
import training.Robot;

public class Factory {

    public static IElbow create(){
        return switch (Robot.ROBOT_TYPE){
            case REAL -> new NeoElbow();
            case SIMULATION -> new SimulationElbow();
        };
    }

}
