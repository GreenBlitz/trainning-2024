package training.Elbow.SimulationElbow;

import com.ctre.phoenix6.configs.CurrentLimitsConfigs;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;

public class SimulationElbowConstants {

	protected static final TalonFXConfiguration CONFIG = new TalonFXConfiguration();


	static {
		CONFIG.Slot0.kP = 0.32;
		CONFIG.Slot0.kI = 0;
		CONFIG.Slot0.kD = 0;

		CONFIG.Slot0.kS = 0;
		CONFIG.Slot0.kG = 0;
		CONFIG.Slot0.kV = 0;
		CONFIG.Slot0.kA = 0;

		CONFIG.CurrentLimits = new CurrentLimitsConfigs();
		CONFIG.Feedback.RotorToSensorRatio = 28.0 * (60.0 / 16.0);
	}

}
