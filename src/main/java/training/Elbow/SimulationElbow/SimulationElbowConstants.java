package training.Elbow.SimulationElbow;

import com.ctre.phoenix6.configs.CurrentLimitsConfigs;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;

public class SimulationElbowConstants {

	protected static final TalonFXConfiguration CONFIG = new TalonFXConfiguration();

	static {
		CONFIG.withSlot0(new Slot0Configs().withKP(0.32).withKD(0).withKI(0).withKG(0).withKS(0).withKA(0).withKV(0));
		CONFIG.withCurrentLimits(new CurrentLimitsConfigs());
		CONFIG.Feedback.RotorToSensorRatio = 28.0 * (60.0 / 16.0);
	}

}
