package training.subsystems.ArmSubsystems.RollerPackage;

import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import utils.GBSubsystem;

public class Roller extends GBSubsystem {

    private final CANSparkMax motor;
    private static Roller instance;

    private Roller() {
        this.motor = new CANSparkMax(RollerConstants.ROLLER_ID, CANSparkLowLevel.MotorType.kBrushless);
    }

    @Override
    protected String getLogPath() {
        return null;
    }

    @Override
    protected void subsystemPeriodic() {

    }

    public static Roller getInstance(){
        if(instance==null){
            instance=new Roller();
        }
        return instance;
    }

    public void rollClockwise() {
        motor.set(RollerConstants.DEFAULT_ROLLER_CLOCKWISE_POWER);
    }

    public void rollBCounterClockwise() {
        motor.set(RollerConstants.DEFAULT_ROLLER_COUNTER_CLOCKWISE_POWER);
    }

    public void stop() {
        motor.set(0);
    }

    public double getRollerVelocity() {
        return motor.getEncoder().getVelocity();
    }

}
