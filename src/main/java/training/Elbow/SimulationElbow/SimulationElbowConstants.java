package training.Elbow.SimulationElbow;

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

	protected static final PIDController CONTROLLER = new PIDController(3, 0, 0); // Outputs power

	protected static final ArmFeedforward FEEDFORWARD = new ArmFeedforward(0, 1.4, 0, 0); // Keep kV and kA 0

}
