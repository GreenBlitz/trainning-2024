package training.subsystems.Arm.Wrist.SimulationWrist;

import com.ctre.phoenix6.configs.Slot0Configs;
import training.subsystems.Arm.Wrist.WristConstants;

public class SimulationWristConstants {

    public static final int NUMBER_OF_MOTORS = 1;
    public static final double GEAR_RATIO = 1;
    public static final Slot0Configs SLOT_0_CONFIGS = new Slot0Configs()
            .withKP(WristConstants.KP)
            .withKI(WristConstants.KI)
            .withKD(WristConstants.KD);
}
