package training.Elbow;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.math.geometry.Rotation2d;
import utils.GBSubsystem;

import static training.Elbow.ElbowConstants.ELBOW_GEAR_RATIO;
import static training.Elbow.ElbowConstants.ELBOW_LOG_PATH;
import static training.Elbow.ElbowConstants.ELBOW_PID_CONTROLLER;
import static training.Elbow.ElbowConstants.ELBOW_ID;
import static training.Elbow.ElbowConstants.ELBOW_MOTOR_TYPE;
import static training.Elbow.ElbowConstants.DEFAULT_POSITION_ELBOW;
import static training.Elbow.ElbowConstants.POWER_LIMIT_ELBOW;
import static training.Elbow.ElbowConstants.ELBOW_TOLERANCE;
import static training.Elbow.ElbowConstants.ELBOW_FEEDFORWARD;
import static training.Elbow.ElbowConstants.PID_SLOT;

public class NeoElbow extends GBSubsystem implements IElbow {
    private static NeoElbow instance;

    public static NeoElbow getInstance() {
        if (instance == null) {
            instance = new NeoElbow();
        }
        return instance;
    }

    private final CANSparkMax motor;
    private final Rotation2d flooredStartRotations;
    private Rotation2d targetAngle;

    private NeoElbow() {
        this.targetAngle = DEFAULT_POSITION_ELBOW;
        this.motor = new CANSparkMax(ELBOW_ID, ELBOW_MOTOR_TYPE);
        this.flooredStartRotations = Rotation2d.fromRotations(Math.floor(motor.getEncoder().getPosition()));

        motor.getEncoder().setPositionConversionFactor(ELBOW_GEAR_RATIO);
        motor.getPIDController().setP(ELBOW_PID_CONTROLLER.getP());
        motor.getPIDController().setD(ELBOW_PID_CONTROLLER.getD());
        motor.getPIDController().setI(ELBOW_PID_CONTROLLER.getI());
        motor.getPIDController().setOutputRange(-POWER_LIMIT_ELBOW, POWER_LIMIT_ELBOW);
        motor.burnFlash();
    }

    @Override
    public Rotation2d getMotorAngle() {
        return Rotation2d.fromRotations(motor.getEncoder().getPosition());
    }

    @Override
    public Rotation2d getTargetAngle() {
        return targetAngle;
    }

    @Override
    public void setTargetAngle(Rotation2d targetAngle) {
        this.targetAngle = targetAngle;
    }

    @Override
    public void addToAngle(Rotation2d angle) {
        this.targetAngle = this.targetAngle.plus(angle);
    }

    @Override
    public void subtractFromAngle(Rotation2d angle) {
        this.targetAngle = this.targetAngle.minus(angle);
    }

    @Override
    public boolean isAtAngle(Rotation2d angle) {
        double anglesDelta = (this.targetAngle.getDegrees() % 360) - (angle.getDegrees() % 360);
        return Math.abs(anglesDelta) <= ELBOW_TOLERANCE.getDegrees();
    }

    @Override
    protected String getLogPath() {
        return ELBOW_LOG_PATH;
    }

    @Override
    public Rotation2d getCurrentAngle() {
        return Rotation2d.fromRotations(motor.getEncoder().getPosition());
    }

    @Override
    public void LockElbowInPlace() {
        targetAngle = getCurrentAngle();
    }

    @Override
    public void subsystemPeriodic() {
        double target = flooredStartRotations.getRotations() + (targetAngle.getRotations() % 1);
        double FFValue = ELBOW_FEEDFORWARD.calculate(getCurrentAngle().getRadians(), motor.getEncoder().getVelocity());

        motor.getPIDController().setReference(
                target,
                CANSparkBase.ControlType.kPosition,
                PID_SLOT,
                FFValue
        );
    }
}
