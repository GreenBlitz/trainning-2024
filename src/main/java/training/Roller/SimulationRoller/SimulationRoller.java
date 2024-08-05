package training.Roller.SimulationRoller;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.simulation.DCMotorSim;
import training.Roller.IRoller;
import training.Roller.RollerDirection;

import static training.Roller.RollerConstants.*;

public class SimulationRoller implements IRoller {
    private final DCMotorSim motor;

    public SimulationRoller() {
        this.motor = new DCMotorSim(DCMotor.getNEO(1), SimulationRollerConstants.ROLLER_GEARING, SimulationRollerConstants.POWER_TO_ACCELERATION);
    }

    @Override
    public void setPower(double power) {
        motor.setInputVoltage(power);
    }

    @Override
    public Rotation2d getPosition() {
        return Rotation2d.fromRotations(motor.getAngularPositionRotations());
    }

    @Override
    public Rotation2d getVelocity() {
        return Rotation2d.fromRotations(motor.getAngularPositionRotations());
    }

    @Override
    public void updateVelocity(Rotation2d targetVelocity, RollerDirection direction) {
        SimulationRollerConstants.ROLLER_SIMULATION_CONTROLLER.setSetpoint(targetVelocity.times(direction.toInt()).getRadians());
        setPower(SimulationRollerConstants.ROLLER_SIMULATION_CONTROLLER.calculate(motor.getAngularPositionRad(), motor.getAngularVelocityRadPerSec()));
    }

}
