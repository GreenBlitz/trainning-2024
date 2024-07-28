package training.subsystems.ArmSubsystems;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.geometry.Rotation2d;
import utils.GBSubsystem;

public class Elbow extends GBSubsystem {

    private final CANSparkMax motor;
    private final Rotation2d targetPosition;
    @Override
    protected String getLogPath( ) {
        return null;
    }

    @Override
    protected void subsystemPeriodic() {

    }

    public Elbow() {
        this.motor =new CANSparkMax(ElbowConstants.ELBOW_ID, CANSparkLowLevel.MotorType.kBrushless);
        this.targetPosition= ElbowConstants.ELBOW_STARTING_POSITION;
        motor.getPIDController().setP(ElbowConstants.ELBOW_P_VALUE);
        motor.getPIDController().setI(ElbowConstants.ELBOW_I_VALUE);
        motor.getPIDController().setD(ElbowConstants.ELBOW_D_VALUE);
    }

    public void moveElbow(Rotation2d position) {
//        motor.set(power);
        motor.getPIDController().setReference(
                position.getDegrees(),
                CANSparkBase.ControlType.kPosition,
                0,
                new ArmFeedforward(WristConstants.WRIST_KS_VALUE, WristConstants.WRIST_KG_VALUE, WristConstants.WRIST_KV_VALUE, WristConstants.WRIST_KA_VALUE).calculate(getElbowPosition().getRadians(),getElbowVelocity())
        );
    }

    public void stayAtPosition(){
        moveElbow(getElbowPosition());
    }

    public Rotation2d getElbowPosition(){
        return Rotation2d.fromRotations(motor.getEncoder().getPosition());
    }

    public double getElbowVelocity(){
        return motor.getEncoder().getVelocity();
    }

    public boolean isAtTarget(Rotation2d target, Rotation2d tolerance) {
        return Math.abs(getElbowPosition().getDegrees() - target.getDegrees()) <= tolerance.getDegrees();
    }
}
