package training.subsystems.Arm.Roller;

import training.Robot;
import training.subsystems.Arm.Elbow.SimulationElbow.SimulationElbow;
import training.subsystems.Arm.Roller.NeoRoller.NeoRoller;

public class RollerFactory {
    public static IRoller create() {
        IRoller elbow;
        switch (Robot.ROBOT_TYPE) {
            case SYNCOPA -> {
                elbow = new NeoRoller();
            }
            case SIMULATION -> {
                throw new UnsupportedOperationException("Feature incomplete. Skill issue.");
            }
            default -> {
                elbow = null;
            }
        }
        return elbow;
    }
}
