package training.subsystems.Arm;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.geometry.Rotation2d;
import utils.GBSubsystem;

public class ElbowSubsystem  extends GBSubsystem {
    private final CANSparkMax motor;
    private final Rotation2d targetPosition;

    @Override
    protected String getLogPath() {
        return null;
    }

    @Override
    protected void subsystemPeriodic() {

    }

    public ElbowSubsystem(){
        this.motor = new CANSparkMax(ArmConstants.ELBOW_ID, CANSparkLowLevel.MotorType.kBrushless);
        this.targetPosition = ArmConstants.ELBOW_START_POSITION;
        motor.getPIDController().setP(ArmConstants.ELBOW_P);
        motor.getPIDController().setI(ArmConstants.ELBOW_I);
        motor.getPIDController().setD(ArmConstants.ELBOW_D);
    }

    public void moveElbow(Rotation2d position){
        new ArmFeedforward(ArmConstants.ELBOW_KS, ArmConstants.ELBOW_KG, ArmConstants.ELBOW_KV, ArmConstants.ELBOW_KA);
            motor.getPIDController().setReference(
                    position.getDegrees(),
                    CANSparkBase.ControlType.kPosition,
                    0,
                    new ArmFeedforward(ArmConstants.ELBOW_KS, ArmConstants.ELBOW_KG, ArmConstants.ELBOW_KV, ArmConstants.ELBOW_KA).calculate(position.getRadians(),getSpeed())
            );

    }

    public void stayAtPosition(){
        moveElbow();
    }

    public Rotation2d getPosition(){
        return Rotation2d.fromRotations(motor.getEncoder().getPosition());
    }

    public double getSpeed(){
        return motor.getEncoder().getVelocity();
    }

    public boolean isAtPosition(Rotation2d target, double tolerance){
        return Math.abs(getPosition().getDegrees() - target.getDegrees()) <= tolerance;
    }

}
