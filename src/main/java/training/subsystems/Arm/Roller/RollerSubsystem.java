package training.subsystems.Arm.Roller;

import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import utils.GBSubsystem;

public class RollerSubsystem extends GBSubsystem {
    private final CANSparkMax motor;

    @Override
    protected String getLogPath() {
        return null;
    }

    @Override
    protected void subsystemPeriodic() {

    }

    public RollerSubsystem(){
        this.motor = new CANSparkMax(RollerConstants.ROLLER_ID, CANSparkLowLevel.MotorType.kBrushless);
    }

    public void setPower(double power){
        motor.set(power);
    }

    public void stop(){
        motor.set(0);
    }

    public double getVelocity(){
        return motor.getEncoder().getVelocity();
    }

    public void reverseRoller(){
        setPower(-RollerConstants.DEFAULT_SPEED);
    }
}
