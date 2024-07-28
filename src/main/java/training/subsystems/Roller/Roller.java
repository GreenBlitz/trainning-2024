package training.subsystems.Roller;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkPIDController;
import utils.GBSubsystem;

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
    private final SparkPIDController motorPID;
    private double targetVelocity;
    private boolean run;
    private RollerDirection direction;

    private Roller() {
        motor = new CANSparkMax(ROLLER_ID, CANSparkLowLevel.MotorType.kBrushless);
        motorPID = motor.getPIDController();

        motorPID.setP(ROLLER_P);
        motorPID.setI(ROLLER_I);
        motorPID.setD(ROLLER_D);
        motorPID.setOutputRange(0, POWER_LIMIT_ROLLER);
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
        motorPID.setReference(targetVelocity * direction.toInt(), CANSparkBase.ControlType.kVelocity);
    }

    @Override
    protected String getLogPath() {
        return ROLLER_LOG_PATH;
    }
}
