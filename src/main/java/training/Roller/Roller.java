package training.Roller;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkMax;
import utils.GBSubsystem;

import static training.Roller.RollerConstants.ROLLER_ID;
import static training.Roller.RollerConstants.ROLLER_MOTOR_TYPE;
import static training.Roller.RollerConstants.ROLLER_GEAR_RATIO;
import static training.Roller.RollerConstants.ROLLER_P;
import static training.Roller.RollerConstants.ROLLER_I;
import static training.Roller.RollerConstants.ROLLER_D;
import static training.Roller.RollerConstants.POWER_LIMIT_ROLLER;
import static training.Roller.RollerConstants.ROLLER_DEFAULT_VELOCITY_RPM;
import static training.Roller.RollerConstants.ROLLER_LOG_PATH;

import static training.Roller.RollerDirection.kBackward;
import static training.Roller.RollerDirection.kForward;

public class Roller extends GBSubsystem implements IRoller {
    private static Roller instance;

    public static Roller getInstance() {
        if (instance == null) {
            instance = new Roller();
        }
        return instance;
    }

    private final CANSparkMax motor;
    private double targetVelocity;
    private RollerDirection direction;

    private Roller() {
        this.motor = new CANSparkMax(ROLLER_ID, ROLLER_MOTOR_TYPE);

        motor.getEncoder().setPositionConversionFactor(ROLLER_GEAR_RATIO);
        motor.getPIDController().setP(ROLLER_P);
        motor.getPIDController().setI(ROLLER_I);
        motor.getPIDController().setD(ROLLER_D);
        motor.getPIDController().setOutputRange(-POWER_LIMIT_ROLLER, POWER_LIMIT_ROLLER);
        motor.burnFlash(); // applies some of the changes above

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
        motor.set(0);
    }

    @Override
    public void subsystemPeriodic() {
        motor.getPIDController().setReference(targetVelocity * direction.toInt(), CANSparkBase.ControlType.kVelocity);
    }

    @Override
    protected String getLogPath() {
        return ROLLER_LOG_PATH;
    }
}
