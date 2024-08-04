package training.subsystems;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.math.geometry.Rotation2d;
import training.ElbowConstants;
import utils.GBSubsystem;

public class Elbow extends GBSubsystem {

    private final CANSparkMax motor;

    @Override
    protected String getLogPath() {
        return "";
    }

    @Override
    protected void subsystemPeriodic() {
    }


    public void moveToAngle(Rotation2d position) {
        motor.getPIDController().setReference(position.getRotations(), CANSparkBase.ControlType.kPosition);
    }

    public Rotation2d getPosition() {
        return Rotation2d.fromRotations(motor.getEncoder().getPosition());
    }

    public void stopMotor() {
        motor.stopMotor();
    }

    public Elbow() {
        this.motor = new CANSparkMax(ElbowConstants.MOTOR_ID, CANSparkLowLevel.MotorType.kBrushless);
        motor.getEncoder().setPosition(ElbowConstants.STARTING_POSITION.getRotations());
        motor.getEncoder().setPositionConversionFactor(ElbowConstants.POSITION_CONVERSION_FACTOR);
        motor.getEncoder().setVelocityConversionFactor(ElbowConstants.VELOCITY_CONVERSION_FACTOR);
        motor.getPIDController().setP(ElbowConstants.KP_VALUE);
        motor.getPIDController().setI(ElbowConstants.KI_VALUE);
        motor.getPIDController().setD(ElbowConstants.KD_VALUE);
    }
}
