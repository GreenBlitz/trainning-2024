package training.Roller;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import utils.GBSubsystem;

import static training.Roller.RollerConstants.*;
import static training.Roller.RollerDirection.kBackward;
import static training.Roller.RollerDirection.kForward;

public class Roller extends GBSubsystem {
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
        this.motor = new CANSparkMax(ROLLER_ID, CANSparkLowLevel.MotorType.kBrushless);

        motor.getEncoder().setPositionConversionFactor(ROLLER_GEAR_RATIO);
        motor.getPIDController().setP(ROLLER_P);
        motor.getPIDController().setI(ROLLER_I);
        motor.getPIDController().setD(ROLLER_D);
        motor.getPIDController().setOutputRange(-POWER_LIMIT_ROLLER, POWER_LIMIT_ROLLER);
        motor.burnFlash(); // applies some of the changes above

        this.targetVelocity = ROLLER_DEFAULT_VELOCITY_RPM;
    }

    public double getTargetVelocity() {
        return targetVelocity;
    }

    public void setTargetVelocity(double targetVelocity) {
        this.targetVelocity = targetVelocity;
    }

    public void runForward() {
        this.targetVelocity = ROLLER_DEFAULT_VELOCITY_RPM;
        direction = kForward;
    }

    public void runBackward() {
        this.targetVelocity = ROLLER_DEFAULT_VELOCITY_RPM;
        direction = kBackward;
    }

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
