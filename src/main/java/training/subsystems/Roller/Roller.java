package training.subsystems.Roller;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkPIDController;
import utils.GBSubsystem;

import static training.subsystems.Elbow.ElbowConstants.ELBOW_GEAR_RATIO;
import static training.subsystems.Roller.RollerConstants.*;
import static training.subsystems.Roller.RollerDirection.kBackward;
import static training.subsystems.Roller.RollerDirection.kForward;

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
    private boolean run;
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
        run = true;
        direction = kForward;
    }

    public void runBackward() {
        run = true;
        direction = kBackward;
    }

    public void stop() {
        run = false;
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
