package training.subsystems.arm.elbow;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.math.geometry.Rotation2d;
import utils.GBSubsystem;

public class Elbow extends GBSubsystem {
    @Override
    protected String getLogPath() {
        return null;
    }

    @Override
    protected void subsystemPeriodic() {

    }
    private final CANSparkMax motor;

    public Elbow(){
        this.motor = new CANSparkMax(Constants.MOTOR_ID, CANSparkLowLevel.MotorType.kBrushless);
        motor.getEncoder().setPositionConversionFactor(Constants.GEAR_RATIO);
        motor.getPIDController().setP(Constants.P);
        motor.getPIDController().setI(Constants.I);
        motor.getPIDController().setD(Constants.D);

    }

    public Rotation2d getCurrentAngle(){
        return Rotation2d.fromRotations(motor.getEncoder().getPosition());
    }
    public void setMotorPower(double power){
        motor.set(power);
    }
    public boolean isAtAngle(Rotation2d angle){
        return Math.abs((getCurrentAngle().getDegrees() - angle.getDegrees())) <= Constants.TOLERANCE.getDegrees();
    }
    public Rotation2d getCurrentVelocity(){
        return Rotation2d.fromRotations(motor.getEncoder().getVelocity());
    }
    public void moveToAngle(Rotation2d angle){
        motor.getPIDController().setReference(
                angle.getRotations(),
                CANSparkBase.ControlType.kPosition,
                0,
                Constants.ELBOW_FEEDFORWARD.calculate(getCurrentAngle().getRotations(), getCurrentVelocity().getRotations())


    }
    public void stayInPlace(){

    }
}
