package training;

import training.subsystems.Elbow.ElbowSubsystem;
import training.subsystems.Roller.RollerSubsystem;
import training.subsystems.Wrist.WristSubsystem;

public class Robot {

    // Enter your subsystems...

    public Robot() {
        WristSubsystem.getInstance();
        ElbowSubsystem.getInstance();
        RollerSubsystem.getInstance();
    }

    // Add your subsystems getters...

}
