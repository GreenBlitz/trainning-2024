package training.Elbow.SimulationElbow;

import com.ctre.phoenix6.configs.CurrentLimitsConfigs;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.system.plant.DCMotor;

public class SimulationElbowConstants {

	protected static final PIDController CONTROLLER = new PIDController(3, 0, 1); // Outputs power

	protected static final ArmFeedforward FEEDFORWARD = new ArmFeedforward(0, 12, 0, 0); // Keep kV and kA 0

	protected static final TalonFXConfiguration CONFIG = new TalonFXConfiguration();

	static {
		CONFIG.withSlot0(new Slot0Configs()
				.withKP(0.8)
				.withKD(0)
				.withKI(0)
				.withKG(0)
				.withKS(0)
				.withKA(0)
				.withKV(0)
		);
		CONFIG.withCurrentLimits(new CurrentLimitsConfigs());
		CONFIG.Feedback.RotorToSensorRatio = 28.0 * (60.0 / 16.0);
	}

}
