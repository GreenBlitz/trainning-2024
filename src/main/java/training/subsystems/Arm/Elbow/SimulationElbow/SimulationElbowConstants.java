package training.subsystems.Arm.Elbow.SimulationElbow;

import com.ctre.phoenix6.configs.Slot0Configs;
import training.subsystems.Arm.Elbow.ElbowConstants;

public class SimulationElbowConstants {
    
    public static final int NUMBER_OF_MOTORS = 1;

    public static final Slot0Configs SLOT_0_CONFIGS = new Slot0Configs()
            .withKP(ElbowConstants.KP)
            .withKI(ElbowConstants.KI)
            .withKD(ElbowConstants.KD);
}