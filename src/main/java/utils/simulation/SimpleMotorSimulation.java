package utils.simulation;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.simulation.DCMotorSim;
import utils.DefaultRobotManager;

/**
 * This class simulates a motor. Used for Subsystems like rollers and intake.
 */
public class SimpleMotorSimulation extends MotorSimulation {

    private final DCMotorSim motorSimulation;

    private SimpleMotorSimulation(DCMotorSim motorSimulation) {
        this.motorSimulation = motorSimulation;
    }

    public SimpleMotorSimulation() {
        this(new DCMotorSim(DCMotor.getFalcon500Foc(1), 1, 0.003));
    }

    public double getCurrent() {
        return motorSimulation.getCurrentDrawAmps();
    }

    @Override
    public Rotation2d getPosition() {
        return Rotation2d.fromRadians(motorSimulation.getAngularPositionRad());
    }

    @Override
    public Rotation2d getVelocity() {
        return Rotation2d.fromRadians(motorSimulation.getAngularVelocityRadPerSec());
    }

    @Override
    protected void setInputVoltage(double voltage) {
        motorSimulation.setInputVoltage(voltage);
    }

    @Override
    protected void updateMotor() {
        motorSimulation.update(DefaultRobotManager.defaultPeriodSecs);
    }

}
