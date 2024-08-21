package training.subsystems.Arm.Roller.SimulationRoller;

import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.simulation.DCMotorSim;
import training.Robot;
import training.subsystems.Arm.Roller.IRoller;

public class SimulationRoller implements IRoller {
    private final DCMotorSim motor;

    public SimulationRoller() {
        motor = new DCMotorSim(DCMotor.getNEO(SimulationRollerConstants.NUMBER_OF_MOTORS),
                SimulationRollerConstants.GEAR_RATIO,
                SimulationRollerConstants.MOMENT_OF_INERTIA);
    }

    public void setVelocity(double velocity) {
        motor.setInputVoltage(velocity * Robot.SIMULATION_BATTERY_VOLTAGE);
    }

    public void stopMotor() {
        setVelocity(0);
    }
}
