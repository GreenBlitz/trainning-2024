package training;

import training.Elbow.NeoElbow;
import training.Roller.NeoRoller;
import training.Wrist.NeoWrist;

public class Robot {

    // Enter your subsystems...

    public Robot() {
        NeoWrist.getInstance();
        NeoElbow.getInstance();
        NeoRoller.getInstance();
    }

    public static RobotType getRobotType() {
        return RobotType.Simulation;
    }

    // Add your subsystems getters...

}
