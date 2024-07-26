package training.subsystems.Roller;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkPIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import utils.GBSubsystem;

import static training.subsystems.Roller.RollerConstants.*;

public class Roller extends GBSubsystem {
    private static Roller instance;
    private final CANSparkMax motor = new CANSparkMax(ROLLER_ID, CANSparkLowLevel.MotorType.kBrushless);
    private final SparkPIDController motorPID = motor.getPIDController();
    private double targetVelocity;
    private boolean run;

    private Roller() {
        motorPID.setP(ROLLER_P);
        motorPID.setI(ROLLER_I);
        motorPID.setD(ROLLER_D);
        motorPID.setOutputRange(0, POWER_LIMIT_ROLLER);
        motor.burnFlash(); // applies some of the changes above

        this.targetVelocity = ROLLER_DEFAULT_VELOCITY_RPM;
    }

    public static Roller getInstance() {
        if (instance == null) {
            instance = new Roller();
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
        motorPID.setReference(targetVelocity, CANSparkBase.ControlType.kVelocity); // Should be calibrated
        if (targetVelocity > VELOCITY_LIMIT_ROLLER) {
            SmartDashboard.putString("maximum roller safety velocity exceeded. Change subsystem.Constants to remove this message", "");
        }
    }

    @Override
    protected String getLogPath() {
        return ROLLER_LOGPATH;
    }
}
