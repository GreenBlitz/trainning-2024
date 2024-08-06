package subsystems.Roller;

import com.revrobotics.CANSparkMax;
import utils.GBSubsystem;

public class Roller extends GBSubsystem {

	private static Roller instance;
	private static CANSparkMax motor;

	private Roller() {
		motor = new CANSparkMax(RollerConstants.ROLLER_MOTOR_ID, RollerConstants.ROLLER_MOTOR_BRUSHLESS_TYPE);
	}

	public static Roller getInstance() {
		if (instance == null) {
			instance = new Roller();
		}
		return instance;
	}

	public void setRotationalSpeed(double rotationalSpeed) {
		motor.getPIDController().setReference(rotationalSpeed, RollerConstants.ROLLER_CONTROL_TYPE);
	}

	public void stop() {
		motor.set(0);
	}

	@Override
	protected String getLogPath() {
		return "";
	}

	@Override
	protected void subsystemPeriodic() {}

}
