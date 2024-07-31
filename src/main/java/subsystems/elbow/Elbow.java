package subsystems.elbow;

import com.revrobotics.CANSparkMax;
import edu.wpi.first.math.geometry.Rotation2d;
import utils.GBSubsystem;

public class Elbow extends GBSubsystem {
    private static Elbow instance;
    private static CANSparkMax motor;

    private Elbow() {
        motor = new CANSparkMax(ElbowConstants.ELBOW_MOTOR_ID, ElbowConstants.ELBOW_MOTOR_BRUSHLESS_TYPE);
    }

    public static Elbow getInstance() {
        if (instance == null) {
            instance = new Elbow();
        }
        return instance;
    }

    public Rotation2d getAngle() {
        return Rotation2d.fromRotations(motor.getEncoder().getPosition() % ElbowConstants.SINGLE_ROTATION);
    }

    public double getRPMVelocity() {
        return motor.getEncoder().getVelocity();
    }

    private double calculateFeedForward() {
        return ElbowConstants.ELBOW_FEED_FORWARD.calculate(getAngle().getRadians(), getRPMVelocity());
    }

    public void GoToPosition(Rotation2d position) {
        motor.getPIDController().setReference(position.getRadians(), ElbowConstants.ELBOW_CONTROL_TYPE, ElbowConstants.WRIST_PID_SLOT, calculateFeedForward());
    }

    @Override
    protected String getLogPath() {
        return "";
    }

    @Override
    protected void subsystemPeriodic() {

    }
}
