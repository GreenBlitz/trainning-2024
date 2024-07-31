package training;

import training.subsystems.ArmSubsystems.ElbowPackage.Elbow;
import training.subsystems.ArmSubsystems.RollerPackage.Roller;
import training.subsystems.ArmSubsystems.WristPackage.Wrist;

public class Robot {

    // Enter your subsystems...

    private final Elbow elbow;
    private final Wrist wrist;
    private final Roller roller;

    public Robot() {
        // Boot your subsystems...
        elbow = Elbow.getInstance();
        wrist = Wrist.getInstance();
        roller = Roller.getInstance();

    }
    // Add your subsystems getters...
}