package training.subsystems.ArmSubsystems.rollerSubsystem;

import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import utils.GBSubsystem;

public class Roller extends GBSubsystem {

	private final CANSparkMax motor;

	public Roller() {
		this.motor = new CANSparkMax(RollerConstants.ROLLER_ID, CANSparkLowLevel.MotorType.kBrushless);
	}

	@Override
	protected String getLogPath() {
		return null;
	}

	@Override
	protected void subsystemPeriodic() {}

	public void rollClockwise() {
		motor.set(RollerConstants.DEFAULT_ROLLER_CLOCKWISE_POWER);
	}

	public void rollCounterClockwise() {
		motor.set(RollerConstants.DEFAULT_ROLLER_COUNTER_CLOCKWISE_POWER);
	}

	public void stop() {
		motor.set(0);
	}

	public double getVelocity() {
		return motor.getEncoder().getVelocity();
	}

}
