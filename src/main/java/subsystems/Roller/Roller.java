package subsystems.Roller;

import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Roller extends SubsystemBase {

    private static Roller instance;
    private static CANSparkMax motor;

    private Roller(){
        motor=new CANSparkMax(Constants.ROLLER_MOTOR_ID, Constants.ROLLER_MOTOR_TYPE);
    }

    public static Roller getInstance() {
        if (instance==null){
            instance=new Roller();
        }
        return instance;
    }

    public void setRotationalSpeed(double rotationalSpeed){
        motor.getPIDController().setReference(rotationalSpeed, Constants.ROLLER_CONTROL_TYPE);
    }

    public void stop(){
        motor.set(0);
    }

}
