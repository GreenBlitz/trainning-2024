package training.subsystems.Arm.Elbow.SimulationElbow;

import com.ctre.phoenix6.configs.Slot0Configs;
import training.subsystems.Arm.Elbow.ElbowConstants;

public class SimulationElbowConstants {
    public static final int NUMBER_OF_MOTORS = 1;
    public static final double GEAR_RATIO = 1;
    public static final Slot0Configs SLOT_0_CONFIGS = new Slot0Configs()
            .withKP(ElbowConstants.KP_VALUE)
            .withKI(ElbowConstants.KI_VALUE)
            .withKD(ElbowConstants.KD_VALUE);
}
