package training;

import training.subsystems.Module;

public class Robot {

    private Module module;

    public Robot() {
        this.module = new Module();
    }

    // Add your subsystems getters...
    public Module getModule() {
        return module;
    }
}
