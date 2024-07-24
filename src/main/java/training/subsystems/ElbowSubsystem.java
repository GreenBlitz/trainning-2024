package training.subsystems;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkPIDController;
import edu.wpi.first.math.geometry.Rotation2d;
import utils.GBSubsystem;

import static training.subsystems.Constants.*;

public class ElbowSubsystem extends GBSubsystem {
    private static ElbowSubsystem instance;

    private final CANSparkMax motor = new CANSparkMax(ELBOW_ID, CANSparkLowLevel.MotorType.kBrushless);
    private final SparkPIDController motorPIDF = motor.getPIDController();
    private Rotation2d angle = DEFAULT_POSITION_ELBOW;

    private ElbowSubsystem() {
        motorPIDF.setP(ELBOW_PID_CONTROLLER.getP());
        motorPIDF.setD(ELBOW_PID_CONTROLLER.getD());
        motorPIDF.setI(ELBOW_PID_CONTROLLER.getI());
    }

    public static ElbowSubsystem getInstance() {
        if (instance == null) {
            instance = new ElbowSubsystem();
        }
        return instance;
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
        motorPIDF.setReference(
                angle.getRotations()/ELBOW_GEAR_RATIO % 1,
                CANSparkBase.ControlType.kPosition,
                0,
                ELBOW_FEEDFORWARD.calculate(0, 0)
        );
    }
}
