package robot.subsystems;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkPIDController;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import utils.GBSubsystem;

import static robot.subsystems.Constants.*;

public class ElbowSubsystem extends GBSubsystem {
    private final CANSparkMax motor = new CANSparkMax(ELBOW_ID, CANSparkLowLevel.MotorType.kBrushed);
    private final SparkPIDController motorPIDF = motor.getPIDController();
    private Rotation2d angle = DEFAULT_POSITION_ELBOW;

    public ElbowSubsystem() {
        motorPIDF.setP(ELBOW_P);
        motorPIDF.setI(ELBOW_I);
        motorPIDF.setD(ELBOW_D);
        motorPIDF.setFF(ELBOW_FEEDFORWARD);
        motorPIDF.setIZone(ELBOW_INTEGRAL_EFFECT_ZONE);
        motorPIDF.setOutputRange(0, POWER_LIMIT_ELBOW);
        motor.burnFlash(); // applies some of the changes above
    }

    public void moveWritst(double power) {
        if (Math.abs(power) < POWER_LIMIT_WRIST) {
            motor.set(power);
        }
    }

    public Rotation2d getMotorAngle() {
        return Rotation2d.fromRotations(motor.getEncoder().getPosition());
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

    public boolean isAtAngle(Rotation2d angle) {
        double anglesDelta = (this.angle.getDegrees() % 1) - (angle.getRadians() % 1);
        return Math.abs(anglesDelta) <= ELBOW_TOLERANCE;
    }

    @Override
    protected String getLogPath() {
        return LOGPATH;
    }

    @Override
    public void subsystemPeriodic() {
        motorPIDF.setReference(angle.getRotations() % 1, CANSparkBase.ControlType.kPosition); //! I'm now sure about the correct format for the angle
    }
}
