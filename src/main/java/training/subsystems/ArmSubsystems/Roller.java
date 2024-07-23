package training.subsystems.ArmSubsystems;

import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import utils.GBSubsystem;

public class Roller extends GBSubsystem {

    private CANSparkMax motor;

    @Override
    protected String getLogPath() {
        return null;
    }

    @Override
    protected void subsystemPeriodic() {

    }

    public Roller() {
        this.motor =new CANSparkMax(Arm_constants.ROLLER_ID, CANSparkLowLevel.MotorType.kBrushless);
    }

    public void moveRoller(){
        motor.set(0.3);
    }

    public void reversRoller(){
        motor.set(-0.3);
    }

    public void stopRoller(){
        motor.set(0);
    }


    public double getElbowVelocity(){
        return motor.getEncoder().getVelocity();
    }

}
