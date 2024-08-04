package training.Roller;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.simulation.DCMotorSim;
import utils.GBSubsystem;

import static training.Roller.RollerConstants.*;
import static training.Roller.RollerDirection.kBackward;
import static training.Roller.RollerDirection.kForward;

public class SimulationRoller extends GBSubsystem implements IRoller {
    private final DCMotorSim motor;
    private double targetVelocity;
    private RollerDirection direction;

    public SimulationRoller() {
        this.motor = new DCMotorSim(DCMotor.getNEO(1), ROLLER_GEARING, POWER_TO_ACCELERATION);
        this.targetVelocity = ROLLER_DEFAULT_VELOCITY_RPM;
    }

    @Override
    protected String getLogPath() {
        return ROLLER_LOG_PATH;
    }

    @Override
    public void setPower(double power) {
        motor.setInputVoltage(power);
    }

    @Override
    public Rotation2d getPosition() {
        return null;
    }

    @Override
    public Rotation2d getVelocity() {
        return null;
    }

    @Override
    public void updateVelocity(Rotation2d targetVelocity, RollerDirection direction) {
        ROLLER_SIMULATION_CONTROLLER.setSetpoint(targetVelocity.times(direction.toInt()).getRadians());
        motor.setInputVoltage(ROLLER_SIMULATION_CONTROLLER.calculate(motor.getAngularPositionRad(), motor.getAngularVelocityRadPerSec()));
    }
}
