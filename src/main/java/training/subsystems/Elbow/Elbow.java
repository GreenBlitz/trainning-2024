package training.subsystems.Elbow;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.math.geometry.Rotation2d;
import utils.GBSubsystem;

import static training.subsystems.Elbow.ElbowConstants.*;

public class Elbow extends GBSubsystem {
    private static Elbow instance;
    private static Rotation2d BaseRotations;

    public static Elbow getInstance() {
        if (instance == null) {
            instance = new Elbow();
        }
        return instance;
    }

    private final CANSparkMax motor;
    private Rotation2d targetAngle;

    private Elbow() {
        this.targetAngle = DEFAULT_POSITION_ELBOW;
        this.motor = new CANSparkMax(ELBOW_ID, CANSparkLowLevel.MotorType.kBrushless);
        this.BaseRotations = Rotation2d.fromRotations(motor.getEncoder().getPosition());

        motor.getEncoder().setPositionConversionFactor(ELBOW_GEAR_RATIO);
        motor.getPIDController().setP(ELBOW_PID_CONTROLLER.getP());
        motor.getPIDController().setD(ELBOW_PID_CONTROLLER.getD());
        motor.getPIDController().setI(ELBOW_PID_CONTROLLER.getI());
        motor.getPIDController().setOutputRange(-POWER_LIMIT_ELBOW, POWER_LIMIT_ELBOW);
        motor.burnFlash();
    }

    public Rotation2d getMotorAngle() {
        return Rotation2d.fromRotations(motor.getEncoder().getPosition());
    }

    public Rotation2d getTargetAngle() {
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
        return Math.abs(anglesDelta) <= ELBOW_TOLERANCE.getRadians();
    }

    @Override
    protected String getLogPath() {
        return ELBOW_LOG_PATH;
    }

    public Rotation2d getCurrentAngle() {
        return Rotation2d.fromRotations(motor.getEncoder().getPosition());
    }

    public void LockElbowInPlace() {
        targetAngle = getCurrentAngle();
    }

    @Override
    public void subsystemPeriodic() {
        double target = BaseRotations.getRotations() + (targetAngle.getRotations() % 1);
        double FFValue = ELBOW_FEEDFORWARD.calculate(getCurrentAngle().getRadians(), motor.getEncoder().getVelocity());

        motor.getPIDController().setReference(
                target,
                CANSparkBase.ControlType.kPosition, 0,
                FFValue
                );
    }
}
