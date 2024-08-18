package training;

import training.subsystems.Arm.Elbow.Elbow;
import training.subsystems.Arm.Wrist.Wrist;
import training.subsystems.Module;

public class Robot {

    private final Module module;
    private final Elbow elbow;
    private final Wrist wrist;

    public Robot() {
        this.module = new Module();
        this.elbow = new Elbow();
        this.wrist = new Wrist();
    }

    // Add your subsystems getters...

    public Module getModule() {
        return module;
    }

    public Elbow getElbow() {
        return elbow;
    }

    public Wrist getWrist() {
        return wrist;
    }
}
