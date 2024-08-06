package training.Elbow.SimulationElbow;

import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.system.plant.DCMotor;

public class SimulationElbowConatns {
    protected static double PLANT;

    protected static DCMotor ELBOW_GEARBOX = new DCMotor(0, 0, 0, 0, 0, 0);

    protected static double ELBOW_GEARING = 0;

    protected static double ELBOW_LENGTH_METERS = 0;

    protected static double ELBOW_MASS = 0;

    protected static Rotation2d ELBOW_MINIMUM_ANGLE = Rotation2d.fromRotations(0);

    protected static Rotation2d ELBOW_MAXIMUM_ANGLE = Rotation2d.fromRotations(0);

    protected static PIDController CONTROLLER = new PIDController(0, 0, 0); // Outputs power

    protected static final ArmFeedforward SIMULATION_ELBOW_FEEDFORWARD = new ArmFeedforward(0, 0, 0, 0); // Keep kV and kA 0

}