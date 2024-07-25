package training.subsystems.Roller;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkPIDController;
import utils.GBSubsystem;

import static training.subsystems.Roller.RollerConstants.*;

public class RollerSubsystem extends GBSubsystem {
    private static RollerSubsystem instance;
    private final CANSparkMax motor = new CANSparkMax(ROLLER_ID, CANSparkLowLevel.MotorType.kBrushless);
    private final SparkPIDController motorPID = motor.getPIDController();
    private double targetVelocity;
    private boolean run;

    private RollerSubsystem() {
        motorPID.setP(ROLLER_P);
        motorPID.setI(ROLLER_I);
        motorPID.setD(ROLLER_D);
        motorPID.setOutputRange(0, POWER_LIMIT_ROLLER);
        motor.burnFlash(); // applies some of the changes above

        this.targetVelocity = ROLLER_DEFAULT_VELOCITY_RPM;
    }

    public static RollerSubsystem getInstance() {
        if (instance == null) {
            instance = new RollerSubsystem();
        }
        return instance;
    }

    public double getTargetVelocity() {
        return targetVelocity;
    }

    /**
     * overwriting the default velocity
     */
    public void setTargetVelocity(double targetVelocity) {
        this.targetVelocity = targetVelocity;
    }

    public void run() {
        run = true;
    }

    public void stop() {
        run = false;
    }

    @Override
    public void subsystemPeriodic() {
        if (targetVelocity <= VELOCITY_LIMIT_ROLLER) {
            motorPID.setReference(targetVelocity, CANSparkBase.ControlType.kVelocity); // Should be calibrated
        } else {
            throw new RuntimeException("maximum roller safety velocity exceeded. Change subsystem.Constants to remove this message");
        }
    }

    @Override
    protected String getLogPath() {
        return ROLLER_LOGPATH;
    }
}
