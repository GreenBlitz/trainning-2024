package training.subsystems.Arm.Elbow.SimulationElbow;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import edu.wpi.first.math.geometry.Rotation2d;

public class SimulationElbowConstants {

	protected static final double P = 40;

	protected static final double I = 0;

	protected static final double D = 0;

	public static final int NUMBER_OF_MOTORS = 1;


	public static final double GEAR_RATIO = 1 / (1 / (28.0 * (60.0 / 16.0)));

	public static final int CURRENT_LIMIT = 40;

	public static final String notMagic = "Elbow";

}
