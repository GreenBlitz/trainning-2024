package training.subsystems.Arm;

import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel;
import edu.wpi.first.math.geometry.Rotation2d;
import utils.GBSubsystem;

public class ElbowSubsystem  extends GBSubsystem {
    private CANSparkMax motor;
    private Rotation2d targetPosition;

    @Override
    protected String getLogPath() {
        return null;
    }

    @Override
    protected void subsystemPeriodic() {

    }

    public ElbowSubsystem(){
        this.motor = new CANSparkMax(Constants.ELBOW_ID, CANSparkLowLevel.MotorType.kBrushless);
        this.targetPosition = Constants.ELBOW_START_POSITION;
        motor.getPIDController().setP(Constants.ELBOW_P);
        motor.getPIDController().setI(Constants.ELBOW_I);
        motor.getPIDController().setD(Constants.ELBOW_D);
    }

    public void setSpeed(double power){
        motor.set(power);
    }

    public void stop(){
        motor.set(0);
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
