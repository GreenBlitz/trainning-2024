package subsystems.elbow;

import com.revrobotics.CANSparkMax;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Elbow extends SubsystemBase {
    private static Elbow instance;
    private static CANSparkMax motor;

    private Elbow(){
        motor=new CANSparkMax(Constants.ELBOW_MOTOR_ID,Constants.ELBOW_MOTOR_TYPE);
    }

    public static Elbow getInstance() {
        if (instance==null){
            instance=new Elbow();
        }
        return instance;
    }

    public Rotation2d getAngle(){
        return Rotation2d.fromRotations(motor.getEncoder().getPosition()%Constants.SINGLE_ROTATION);
    }

    public double getRPMVelocity(){
        return motor.getEncoder().getVelocity();
    }

    private double calculateFitForward(){
        return Constants.ELBOW_FIT_ARM.calculate(getAngle().getRadians(),getRPMVelocity());
    }

    public void getToPosition(Rotation2d position){
        motor.getPIDController().setReference(position.getRadians(), Constants.ELBOW_CONTORL_TYPE,Constants.WRIST_PID_SLOT ,calculateFitForward());
    }
}
