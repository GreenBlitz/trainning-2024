package subsystems.Roller;

import com.revrobotics.CANSparkMax;
import subsystems.RevConstants;
import utils.GBSubsystem;

public class Roller extends GBSubsystem {

	private static Roller instance;
	private static CANSparkMax motor;

	private Roller() {
		motor = new CANSparkMax(RollerConstants.MOTOR_ID, RevConstants.MOTOR_BRUSHLESS_TYPE);
	}

	public static Roller getInstance() {
		if (instance == null) {
			instance = new Roller();
		}
		return instance;
	}

	public void setRotationalSpeed(double rotationalSpeed) {
		motor.getPIDController().setReference(rotationalSpeed, RollerConstants.CONTROL_TYPE);
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
