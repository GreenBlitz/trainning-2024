package training;

import training.subsystems.SubsystemOfDOOM;

public class Robot {

    private final SubsystemOfDOOM module;

    public Robot() {
        // Boot your subsystems...
        module = new SubsystemOfDOOM();
    }

    // Add your subsystems getters...


    public SubsystemOfDOOM getModule() {
        return module;
    }
}
