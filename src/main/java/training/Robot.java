package training;

import training.Elbow.Elbow;
import training.Roller.Roller;
import training.Wrist.Wrist;

public class Robot {

    // Enter your subsystems...

    public Robot() {
        Wrist.getInstance();
        Elbow.getInstance();
        Roller.getInstance();
    }

    // Add your subsystems getters...

}
