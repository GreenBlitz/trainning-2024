package training;

import training.subsystems.ElbowSubsystem;
import training.subsystems.RollerSubsystem;
import training.subsystems.WristSubsystem;

public class Robot {

    // Enter your subsystems...

    public Robot() {
        WristSubsystem.getInstance();
        ElbowSubsystem.getInstance();
        RollerSubsystem.getInstance();
    }

    // Add your subsystems getters...

}
