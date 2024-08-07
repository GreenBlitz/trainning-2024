package training.subsystems.ArmSubsystems.roller;

import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.math.geometry.Rotation2d;
import utils.GBSubsystem;

public class Roller extends GBSubsystem {

	private final CANSparkMax motor;

	public Roller() {
		this.motor = new CANSparkMax(RollerConstants.ID, CANSparkLowLevel.MotorType.kBrushless);
	}

	@Override
	protected String getLogPath() {
		return "Roller/";
	}

	@Override
	protected void subsystemPeriodic() {}

	public void rollClockwise() {
		motor.set(RollerConstants.DEFAULT_CLOCKWISE_POWER);
	}

	public void rollCounterClockwise() {
		motor.set(RollerConstants.DEFAULT_COUNTER_CLOCKWISE_POWER);
	}

	public void stop() {
		motor.set(0);
	}

	public Rotation2d getVelocity() {
		return Rotation2d.fromRotations(motor.getEncoder().getVelocity());
	}

}
