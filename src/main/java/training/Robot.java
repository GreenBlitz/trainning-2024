package training;

import training.subsystems.ArmSubsystems.elbowSubsystem.Elbow;
import training.subsystems.ArmSubsystems.rollerSubsystem.Roller;
import training.subsystems.ArmSubsystems.wristSubsystem.Wrist;

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