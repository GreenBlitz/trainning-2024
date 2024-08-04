package training.Roller;

import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.simulation.DCMotorSim;
import utils.GBSubsystem;

import static training.Roller.RollerConstants.*;
import static training.Roller.RollerDirection.kBackward;
import static training.Roller.RollerDirection.kForward;

public class SimulationRoller extends GBSubsystem implements IRoller {
    private static SimulationRoller instance;

    public static SimulationRoller getInstance() {
        if (instance == null) {
            instance = new SimulationRoller();
        }
        return instance;
    }

    private final DCMotorSim motor;
    private double targetVelocity;
    private RollerDirection direction;

    private SimulationRoller() {
        this.motor = new DCMotorSim(DCMotor.getNEO(1), ROLLER_GEARING, POWER_TO_ACCELERATION);
        this.targetVelocity = ROLLER_DEFAULT_VELOCITY_RPM;
    }

    @Override
    public double getTargetVelocity() {
        return targetVelocity;
    }

    @Override
    public void setTargetVelocity(double targetVelocity) {
        this.targetVelocity = targetVelocity;
    }

    @Override
    public void runForward() {
        this.targetVelocity = ROLLER_DEFAULT_VELOCITY_RPM;
        direction = kForward;
    }

    @Override
    public void runBackward() {
        this.targetVelocity = ROLLER_DEFAULT_VELOCITY_RPM;
        direction = kBackward;
    }

    @Override
    public void stop() {
        targetVelocity = 0;
        motor.setInputVoltage(0);
    }

    @Override
    public void subsystemPeriodic() {
        motor.setInputVoltage(SimulationController.calculate(motor.getAngularPositionRad(), motor.getAngularVelocityRadPerSec()));
    }

    @Override
    protected String getLogPath() {
        return ROLLER_LOG_PATH;
    }
}
