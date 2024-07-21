package training.subsystems.ArmSubsystems;

import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.math.geometry.Rotation2d;
import utils.GBSubsystem;

public class Elbow extends GBSubsystem {

    private CANSparkMax motor;
    private Rotation2d targetPosition;
    @Override
    protected String getLogPath() {
        return null;
    }

    @Override
    protected void subsystemPeriodic() {

    }

    public Elbow() {
        this.motor =new CANSparkMax(Arm_constants.ELBOW_ID, CANSparkLowLevel.MotorType.kBrushless);
        this.targetPosition=Arm_constants.ELBOW_STARTING_POSITION;
    }

    public void moveElbow(double power){
        motor.set(power);
    }

    public void stopElbow(){
        motor.set(0);
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
