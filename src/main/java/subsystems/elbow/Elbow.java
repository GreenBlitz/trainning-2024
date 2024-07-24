package subsystems.elbow;

import com.ctre.phoenix6.hardware.TalonFX;
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

    public void getToPosition(Rotation2d position){
        motor.getPIDController().setReference(position.getRadians(), Constants.ELBOW_CONTORL_TYPE);
    }
}
