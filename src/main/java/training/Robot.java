package training;

import training.subsystems.Elbow;
import training.subsystems.Module;

public class Robot {
    
    private final Module module;
    private final Elbow elbow;

    public Robot(){
        this.module = new Module();
        this.elbow = new Elbow();
    }

    // Add your subsystems getters...
    
    
    public Module getModule() {
        return module;
    }
    public Elbow getElbow() {
        return elbow;
    }
}
