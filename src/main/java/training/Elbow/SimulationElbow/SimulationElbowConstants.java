package training.Elbow.SimulationElbow;

import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.system.plant.DCMotor;

public class SimulationElbowConstants {

	protected static final DCMotor GEARBOX = new DCMotor(0, 0, 0, 0, 0, 0);

	protected static final double GEARING = 0;

	protected static final double LENGTH_METERS = 0;

	protected static final double MASS = 0;

	protected static final Rotation2d MINIMUM_ANGLE = Rotation2d.fromRotations(0);

	protected static final Rotation2d MAXIMUM_ANGLE = Rotation2d.fromRotations(0);

	protected static final PIDController CONTROLLER = new PIDController(0, 0, 0); // Outputs power

	protected static final ArmFeedforward FEEDFORWARD = new ArmFeedforward(0, 0, 0, 0); // Keep kV and kA 0

}
