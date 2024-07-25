package training;

import training.subsystems.Elbow.Elbow;
import training.subsystems.Roller.Roller;
import training.subsystems.Wrist.Wrist;

public class Robot {

    // Enter your subsystems...

    public Robot() {
        Wrist.getInstance();
        Elbow.getInstance();
        Roller.getInstance();
    }

    // Add your subsystems getters...

}
