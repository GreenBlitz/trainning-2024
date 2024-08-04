package training;

import training.subsystems.IElbow;
import training.subsystems.NeoElbow.NeoElbow;
import training.subsystems.Module;

public class Robot {
    
    private final Module module;
    private final IElbow elbow;

    public Robot(){
        this.module = new Module();
        this.elbow = new NeoElbow();
    }

    // Add your subsystems getters...
    
    
    public Module getModule() {
        return module;
    }
    public IElbow getElbow() {
        return elbow;
    }
}
