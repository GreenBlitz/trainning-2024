package training.subsystems.Arm.Wrist;

import training.Robot;
import training.subsystems.Arm.Elbow.NeoElbow.NeoElbow;
import training.subsystems.Arm.Wrist.SimulationWrist.SimulationWrist;

public class WristFactory {
    public static IWrist create() {
        IWrist wrist;
        switch (Robot.ROBOT_TYPE) {
            case SYNCOPA -> {
                throw new UnsupportedOperationException("Feature incomplete. Skill issue.");
            }
            case SIMULATION -> {
                wrist = new SimulationWrist();
            }
            default -> {
                wrist = null;
            }
        }
        return wrist;
    }
}
