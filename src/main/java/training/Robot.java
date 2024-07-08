package training;

import training.subsystems.SwerveModule;

public class Robot {

    private final SwerveModule module;

    public Robot() {
        // Boot your subsystems...
        module = new SwerveModule();
    }

    // Add your subsystems getters...


    public SwerveModule getModule() {
        return module;
    }
}
