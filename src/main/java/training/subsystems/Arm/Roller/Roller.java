package training.subsystems.Arm.Roller;

import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import utils.GBSubsystem;

public class Roller extends GBSubsystem {
    private final CANSparkMax motor;
    private static Roller instance;

    @Override
    protected String getLogPath() {
        return null;
    }

    @Override
    protected void subsystemPeriodic() {

    }

    public Roller() {
        this.motor = new CANSparkMax(RollerConstants.ROLLER_ID, CANSparkLowLevel.MotorType.kBrushless);
    }

    public static Roller getInstance() {
        if (instance == null) {
            instance = new Roller();
        }
        return instance;
    }

    public void clockwise() {
        motor.set(RollerConstants.DEFAULT_VELOCITY_CLOCKWISE);
    }

    public void counterClockwise() {
        motor.set(RollerConstants.DEFAULT_VELOCITY_COUNTERCLOCKWISE);
    }

    public void stop() {
        motor.set(0);
    }

    public double getVelocity() {
        return motor.getEncoder().getVelocity();
    }

}
