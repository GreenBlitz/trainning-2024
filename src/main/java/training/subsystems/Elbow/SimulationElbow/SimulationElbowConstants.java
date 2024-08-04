package training.subsystems.Elbow.SimulationElbow;

import com.ctre.phoenix6.configs.Slot0Configs;

public class SimulationElbowConstants {
    public static final int NUMBER_OF_MOTORS = 1;
    public static final double GEAR_RATIO = 1;
    public static final Slot0Configs SLOT_0_CONFIGS = new Slot0Configs()
            .withKP(45)
            .withKI(0)
            .withKD(0);
}
