package training.subsystems.Arm.Wrist;

import training.subsystems.Arm.Elbow.NeoElbow.NeoElbow;
import training.subsystems.Arm.Wrist.SimulationWrist.SimulationWrist;

public class WristFactory {
    public static IWrist create() {
        IWrist elbow;
        switch (WristConstants.ROBOT_TYPE) {
            case SYNCOPA -> {
                throw new UnsupportedOperationException("Feature incomplete. Skill issue.");
            }
            case SIMULATION -> {
                elbow = new SimulationWrist();
            }
            default -> {
                elbow = null;
            }
        }
        return elbow;
    }
}
