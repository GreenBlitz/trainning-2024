package training.subsystems.ArmSubsystems;

import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import utils.GBSubsystem;

public class Roller extends GBSubsystem {

    private final CANSparkMax motor;

    @Override
    protected String getLogPath() {
        return null;
    }

    @Override
    protected void subsystemPeriodic() {

    }

    public Roller() {
        this.motor =new CANSparkMax(RollerConstants.ROLLER_ID, CANSparkLowLevel.MotorType.kBrushless);
    }

    public void rollForward(){
        motor.set(RollerConstants.DEFAULT_ROLLER_POWER);
    }

    public void rollBackward(){
        motor.set(-RollerConstants.DEFAULT_ROLLER_POWER);
    }

    public void stopRoller(){
        motor.set(0);
    }


    public double getRollerVelocity(){
        return motor.getEncoder().getVelocity();
    }

}
