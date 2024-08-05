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

public class NeoElbow implements IElbow {
    private final CANSparkMax motor;
    private final Rotation2d flooredStartRotations;

    public NeoElbow() {
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
    public Rotation2d getCurrentAngle() {
        return Rotation2d.fromRotations(motor.getEncoder().getPosition());
    }

    public Rotation2d getCurrentVelocity() {
        return Rotation2d.fromRotations(motor.getEncoder().getVelocity());
    }

    @Override
    public void updateAngle(Rotation2d targetAngle) {
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
