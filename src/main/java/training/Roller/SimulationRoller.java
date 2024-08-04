package training.Roller;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.simulation.DCMotorSim;
import utils.GBSubsystem;

import static training.Roller.RollerConstants.*;
import static training.Roller.RollerDirection.kBackward;
import static training.Roller.RollerDirection.kForward;

public class SimulationRoller implements IRoller {
    private final DCMotorSim motor;

    public SimulationRoller() {
        this.motor = new DCMotorSim(DCMotor.getNEO(1), ROLLER_GEARING, POWER_TO_ACCELERATION);
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
        ROLLER_SIMULATION_CONTROLLER.setSetpoint(targetVelocity.times(direction.toInt()).getRadians());
        setPower(ROLLER_SIMULATION_CONTROLLER.calculate(motor.getAngularPositionRad(), motor.getAngularVelocityRadPerSec()));
    }
}
