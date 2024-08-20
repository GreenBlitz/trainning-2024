package training.subsystems.Arm.Elbow.SimulationElbow;

import com.ctre.phoenix6.configs.TalonFXConfiguration;

public class SimulationElbowConstants {

	public static final int NUMBER_OF_MOTORS = 1;

	protected static final TalonFXConfiguration CONFIG = new TalonFXConfiguration();
	static {
		CONFIG.Slot0.kP = 40;
		CONFIG.Slot0.kI = 0;
		CONFIG.Slot0.kD = 0;
	}

	public static final double GEAR_RATIO = 28.0 * (60.0 / 16.0);

	public static final String notMagic = "Elbow";

}
