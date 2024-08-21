package training;

import training.subsystems.Arm.Elbow.Elbow;
import training.subsystems.Arm.Roller.Roller;
import training.subsystems.Arm.Wrist.Wrist;
import training.subsystems.Module;

public class Robot {

    private final Module module;
    private final Elbow elbow;
    private final Wrist wrist;
    private final Roller roller;

    public static final RobotType ROBOT_TYPE = RobotType.SIMULATION;

    public static final double BATTERY_VOLTAGE = 12;

    public Robot() {
        this.module = new Module();
        this.elbow = new Elbow();
        this.wrist = new Wrist();
        this.roller = new Roller();
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

    public Roller getRoller() {
        return roller;
    }
}
