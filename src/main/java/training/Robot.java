package training;

import subsystem.ModuleSubsystem;

public class Robot {

    // Enter your subsystems...
    private static final ModuleSubsystem moduleSubsystem = new ModuleSubsystem(0, 1);
    public Robot() {

    }

    // Add your subsystems getters...
    public static ModuleSubsystem getModuleSubsystem() {
        return moduleSubsystem;
    }

}