package subsystems;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkPIDController;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static subsystems.Constants.*;

public class ElbowSubsystem extends SubsystemBase {
    private final CANSparkMax motor = new CANSparkMax(ELBOW_ID, CANSparkLowLevel.MotorType.kBrushed);
    private final SparkPIDController motorPID = motor.getPIDController();
    private Rotation2d angle = DEFAULT_POSITION_ELBOW;

    public ElbowSubsystem() {
        motorPID.setP(ELBOW_P);
        motorPID.setI(ELBOW_I);
        motorPID.setD(ELBOW_D);
    }

    public double getMotorAngle() {
        return motor.getEncoder().getPosition();
    }

    public Rotation2d getDesiredAngle() {
        return angle;
    }

    public void setAngle(Rotation2d angle) {
        this.angle = angle;
    }

    public void addToAngle(Rotation2d angle) {
        this.angle = this.angle.plus(angle);
    }

    public void subtractFromAngle(Rotation2d angle) {
        this.angle = this.angle.minus(angle);
    }

    @Override
    public void periodic() {
        motorPID.setReference(angle.getRotations(), CANSparkBase.ControlType.kPosition); // Should be calibrated
    }


}
