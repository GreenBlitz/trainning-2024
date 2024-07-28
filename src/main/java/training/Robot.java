package training;

import training.subsystems.ArmSubsystems.Elbow;
import training.subsystems.ArmSubsystems.Roller;
import training.subsystems.ArmSubsystems.Wrist;

public class Robot {

    private final Elbow elbow;
    private final Wrist wrist;
    private final Roller roller;

    public Robot() {
        // Boot your subsystems...
        elbow = new Elbow();
        wrist = new Wrist();
        roller = new Roller();

    }

    // Add your subsystems getters...



}
