package training;

import training.subsystems.movement.ModuleSubsystem;

public class Robot {

    // Enter your subsystems...
    private static ModuleSubsystem moduleSubsystem;

    public Robot() {
        // Boot your subsystems...
        moduleSubsystem = new ModuleSubsystem(0, 1);
    }

    // Add your subsystems getters...
    public static ModuleSubsystem getModuleSubsystem() {
        return moduleSubsystem;
    }

}
