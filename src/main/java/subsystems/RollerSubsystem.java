package subsystems;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkPIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static subsystems.Constants.*;
import static subsystems.Constants.ROLLER_D;

public class RollerSubsystem extends SubsystemBase {
    private final CANSparkMax motor = new CANSparkMax(ROLLER_ID, CANSparkLowLevel.MotorType.kBrushed);
    private final SparkPIDController motorPID = motor.getPIDController();
    private double velocity;
    private boolean run;

    public RollerSubsystem() {
        motorPID.setP(ROLLER_P);
        motorPID.setI(ROLLER_I);
        motorPID.setD(ROLLER_D);
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public double getVelocity() {
        return velocity;
    }

    public void run() {
        run = true;
    }

    public void stop() {
        run = false;
    }

    @Override
    public void periodic() {
        motorPID.setReference(velocity, CANSparkBase.ControlType.kVelocity); // Should be calibrated
    }
}
