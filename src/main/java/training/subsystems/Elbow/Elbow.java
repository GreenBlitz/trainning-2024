package training.subsystems.Elbow;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkPIDController;
import edu.wpi.first.math.geometry.Rotation2d;
import utils.GBSubsystem;

import static training.subsystems.Elbow.ElbowConstants.*;

public class Elbow extends GBSubsystem {
    private static Elbow instance;

    private final CANSparkMax motor = new CANSparkMax(ELBOW_ID, CANSparkLowLevel.MotorType.kBrushless);
    private final SparkPIDController motorPIDF = motor.getPIDController();
    private Rotation2d targetAngle;

    private Elbow() {
        targetAngle = DEFAULT_POSITION_ELBOW;

        motorPIDF.setP(ELBOW_PID_CONTROLLER.getP());
        motorPIDF.setD(ELBOW_PID_CONTROLLER.getD());
        motorPIDF.setI(ELBOW_PID_CONTROLLER.getI());
    }

    public static Elbow getInstance() {
        if (instance == null) {
            instance = new Elbow();
        }
        return instance;
    }

    public void moveElbow(double power) {
        if (Math.abs(power) < POWER_LIMIT_ELBOW) {
            motor.set(power);
        }
    }

    public Rotation2d getMotorAngle() {
        return Rotation2d.fromRotations(motor.getEncoder().getPosition());
    }

    public Rotation2d getDesiredAngle() {
        return targetAngle;
    }

    public void setTargetAngle(Rotation2d targetAngle) {
        this.targetAngle = targetAngle;
    }

    public void addToAngle(Rotation2d angle) {
        this.targetAngle = this.targetAngle.plus(angle);
    }

    public void subtractFromAngle(Rotation2d angle) {
        this.targetAngle = this.targetAngle.minus(angle);
    }

    public boolean isAtAngle(Rotation2d angle) {
        double anglesDelta = (this.targetAngle.getDegrees() % 1) - (angle.getRadians() % 1);
        return Math.abs(anglesDelta) <= ELBOW_TOLERANCE;
    }

    @Override
    protected String getLogPath() {
        return ELBOW_LOGPATH;
    }

    @Override
    public void subsystemPeriodic() {
        motorPIDF.setReference(
                (targetAngle.getRotations() % 1) / ELBOW_GEAR_RATIO,
                CANSparkBase.ControlType.kPosition, 0,
                ELBOW_FEEDFORWARD.calculate(0, 0)
                );
    }
}
