package training;

import subsystems.Roller.Roller;
import subsystems.elbow.Elbow;
import subsystems.wrist.Wrist;

public class Robot {

    // Enter your subsystems...
    private final Elbow elbow;
    private final Wrist wrist;
    private final Roller roller;

    public Robot(){
        // Boot your subsystems...
        elbow = Elbow.getInstance();
        wrist = Wrist.getInstance();
        roller = Roller.getInstance();
    }

    // Add your subsystems getters...

}
