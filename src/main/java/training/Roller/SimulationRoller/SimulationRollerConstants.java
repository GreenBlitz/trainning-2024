package training.Roller.SimulationRoller;

import edu.wpi.first.math.controller.PIDController;

public class SimulationRollerConstants {
    protected static final double ROLLER_GEARING = 0;

    protected static final double POWER_TO_ACCELERATION = 0;

    protected static PIDController ROLLER_SIMULATION_CONTROLLER = new PIDController(0, 0, 0);
}
