package training.subsystems.NeoElbow;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.geometry.Rotation2d;
import training.ElbowConstants;
import training.subsystems.IElbow;
import utils.GBSubsystem;

public class NeoElbow extends GBSubsystem implements IElbow {

    private final CANSparkMax motor;

    public NeoElbow() {
        this.motor = new CANSparkMax(ElbowConstants.MOTOR_ID, CANSparkLowLevel.MotorType.kBrushless);
        motor.getEncoder().setPositionConversionFactor(ElbowConstants.POSITION_CONVERSION_FACTOR);
        motor.getEncoder().setVelocityConversionFactor(ElbowConstants.VELOCITY_CONVERSION_FACTOR);
        motor.getPIDController().setP(ElbowConstants.KP_VALUE);
        motor.getPIDController().setI(ElbowConstants.KI_VALUE);
        motor.getPIDController().setD(ElbowConstants.KD_VALUE);
        motor.getEncoder().setPosition(ElbowConstants.STARTING_POSITION.getRotations());
    }
    @Override
    protected String getLogPath() {
        return "";
    }

    @Override
    protected void subsystemPeriodic() {
    }


    public void moveToAngle(Rotation2d position) {
        motor.getPIDController().setReference(
                position.getRotations(),
                CANSparkBase.ControlType.kPosition,
                0,
                ElbowConstants.FEED_FORWARD_PARAMETERS.calculate(
                        getPosition().getRadians(),
                        motor.getEncoder().getVelocity()
                )
        );
    }

    public Rotation2d getPosition() {
        return Rotation2d.fromRotations(motor.getEncoder().getPosition());
    }

    public void stopMotor() {
        motor.stopMotor();
    }

}
