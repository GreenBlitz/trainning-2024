package robot.subsystems;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkPIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import utils.GBSubsystem;

import static robot.subsystems.Constants.*;

public class RollerSubsystem extends GBSubsystem {
    private final CANSparkMax motor = new CANSparkMax(ROLLER_ID, CANSparkLowLevel.MotorType.kBrushed);
    private final SparkPIDController motorPID = motor.getPIDController();
    private double velocity;
    private boolean run;

    public RollerSubsystem() {
        motorPID.setP(ROLLER_P);
        motorPID.setI(ROLLER_I);
        motorPID.setD(ROLLER_D);
        motorPID.setOutputRange(0, POWER_LIMIT_ROLLER);
        motor.burnFlash(); // applies some of the changes above

        this.velocity = ROLLER_DEFAULT_VELOCITY;
    }

    public double getVelocity() {
        return velocity;
    }

    /**
     * overwriting the default velocity
     */
    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public void run() {
        run = true;
    }

    public void stop() {
        run = false;
    }

    @Override
    public void subsystemPeriodic() {
        if (velocity <= VELOCITY_LIMIT_ROLLER) {
            motorPID.setReference(velocity, CANSparkBase.ControlType.kVelocity); // Should be calibrated
        } else {
            throw new RuntimeException("maximum roller safety velocity exceeded. Change subsystem.Constants to remove this message");
        }
    }

    @Override
    protected String getLogPath() {
        return LOGPATH;
    }
}
