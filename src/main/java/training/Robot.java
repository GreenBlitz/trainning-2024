package training;

import training.subsystems.movement.ModuleSubsystem;

public class Robot {

    // Enter your subsystems...
    private static final ModuleSubsystem module = new ModuleSubsystem(0, 1);
    public Robot() {


    }

    // Add your subsystems getters...
    public static ModuleSubsystem get() {
        return module;
    }

}

