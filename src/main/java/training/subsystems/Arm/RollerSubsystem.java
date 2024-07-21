package training.subsystems.Arm;

import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.math.geometry.Rotation2d;
import utils.GBSubsystem;

public class RollerSubsystem extends GBSubsystem {
    private CANSparkMax motor;

    @Override
    protected String getLogPath() {
        return null;
    }

    @Override
    protected void subsystemPeriodic() {

    }

    public RollerSubsystem(){
        this.motor = new CANSparkMax(Constants.ROLLER_ID, CANSparkLowLevel.MotorType.kBrushless);
    }

    public void setSpeed(double power){
        motor.set(power);
    }

    public void stop(){
        motor.set(0);
    }

    public double getSpeed(){
        return motor.getEncoder().getVelocity();
    }

}
