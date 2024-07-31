package utils.simulation;

import com.ctre.phoenix6.StatusSignal;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.ControlRequest;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.sim.TalonFXSimState;
import edu.wpi.first.math.geometry.Rotation2d;
import utils.DefaultRobotManager;

import java.sql.SQLOutput;


/**
 * A wrapper class for the WPILib default simulation classes, that'll act similarly to how the TalonFX motor controller works.
 */
abstract class MotorSimulation {

    private final TalonFX motor;

    private final TalonFXSimState motorSimulationState;

    private final StatusSignal<Double> closedLoopReferenceSignal;

    protected MotorSimulation() {
        SimulationManager.addSimulation(this);
        this.motor = SimulationManager.createNewMotorForSimulation();
        this.motorSimulationState = motor.getSimState();
        this.motorSimulationState.setSupplyVoltage(12);
        this.closedLoopReferenceSignal = motor.getClosedLoopReference();
        this.closedLoopReferenceSignal.setUpdateFrequency(1.0 / DefaultRobotManager.defaultPeriodSecs);
    }

    protected void updateSimulation() {
        setInputVoltage(motorSimulationState.getMotorVoltage());
        updateMotor();
        motorSimulationState.setRawRotorPosition(getPosition().getRotations());
        motorSimulationState.setRotorVelocity(getVelocity().getRotations());
    }

    public void applyConfiguration(TalonFXConfiguration config) {
        motor.getConfigurator().apply(config);
    }

    public void setPower(double power) {
        motor.set(power);
    }

    public void stop() {
        motor.stopMotor();
    }

    public void setControl(ControlRequest request) {
        motor.setControl(request);
    }

    public double getVoltage() {
        return motor.getMotorVoltage().getValue();
    }

    public Rotation2d getProfiledSetPoint() {
        return Rotation2d.fromRotations(closedLoopReferenceSignal.refresh().getValue());
    }

    protected abstract void setInputVoltage(double voltage);

    protected abstract void updateMotor();

    public abstract Rotation2d getPosition();

    public abstract Rotation2d getVelocity();

}
