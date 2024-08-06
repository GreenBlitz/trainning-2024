package training;

import training.subsystems.ArmSubsystems.elbowSubsystem.neoElbow.NeoElbow;
import training.subsystems.ArmSubsystems.rollerSubsystem.Roller;
import training.subsystems.ArmSubsystems.wristSubsystem.Wrist;

public class Robot {

    // Enter your subsystems...

    private final NeoElbow elbow;
    private final Wrist wrist;
    private final Roller roller;
    public static final Robot.robotType ROBOT_TYPE = Robot.robotType.SIMULATION;


    public Robot() {
        // Boot your subsystems...
        elbow = NeoElbow.getInstance();
        wrist = Wrist.getInstance();
        roller = Roller.getInstance();
    }


    public enum robotType {
        SYNCOPA,
        SIMULATION,
    }


    // Add your subsystems getters...
}
