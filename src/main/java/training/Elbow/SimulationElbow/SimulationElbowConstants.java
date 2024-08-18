package training.Elbow.SimulationElbow;

import com.ctre.phoenix6.configs.CurrentLimitsConfigs;
import com.ctre.phoenix6.configs.MotorOutputConfigs;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.system.plant.DCMotor;

public class SimulationElbowConstants {

	protected static final DCMotor GEARBOX = DCMotor.getNEO(1);

	protected static final double GEARING = 28.0 * (60.0 / 16.0);

	protected static final double LENGTH_METERS = 0.44;

	protected static final double MASS = 0.44;

	protected static final Rotation2d MINIMUM_ANGLE = Rotation2d.fromRotations(-0.5);

	protected static final Rotation2d MAXIMUM_ANGLE = Rotation2d.fromRotations(0.5);

	protected static final PIDController CONTROLLER = new PIDController(3, 0, 1); // Outputs power

	protected static final ArmFeedforward FEEDFORWARD = new ArmFeedforward(0, 12, 0, 0); // Keep kV and kA 0

	protected static final TalonFXConfiguration config = new TalonFXConfiguration();

	static {
		config.withSlot0(new Slot0Configs()
				.withKP(4)
				.withKD(0)
				.withKI(0)
				.withKG(12)
				.withKS(0)
				.withKA(0)
				.withKV(0)
		);
		config.withCurrentLimits(new CurrentLimitsConfigs());
	}

}
