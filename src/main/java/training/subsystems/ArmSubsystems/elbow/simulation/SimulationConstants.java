package training.subsystems.ArmSubsystems.elbow.simulation;

import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Rotation2d;

public class SimulationConstants {

	public static final int ID = 0;

	public static final double P_VALUE = 150;
	public static final double I_VALUE = 0;
	public static final double D_VALUE = 0;
	public static final PIDController PID_CONTROLLER = new PIDController(P_VALUE, I_VALUE, D_VALUE);

	public static final Rotation2d GEAR_RATIO = Rotation2d.fromDegrees(1 / (1 / (28.0 * (60.0 / 16.0))));

	public static final double KS_VALUE = 0;
	public static final double KG_VALUE = 0.04169848;
	public static final double KV_VALUE = 0;
	public static final double KA_VALUE = 0;

	public static final ArmFeedforward FEEDFORWARD_CONTROLLER = new ArmFeedforward(KS_VALUE, KG_VALUE, KV_VALUE, KA_VALUE);

}
