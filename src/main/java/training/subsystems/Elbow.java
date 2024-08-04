package training.subsystems;

import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import training.ElbowConstants;
import utils.GBSubsystem;

public class Elbow extends GBSubsystem {

    CANSparkMax motor;
    @Override
    protected String getLogPath() {
        return "";
    }

    @Override
    protected void subsystemPeriodic() {
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
