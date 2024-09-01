package subsystems.Roller;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import utils.GBSubsystem;

public class Roller extends GBSubsystem {

	private static Roller instance;
	private static CANSparkMax motor;

	private Roller() {
		this.motor = new CANSparkMax(RollerConstants.MOTOR_ID, CANSparkLowLevel.MotorType.kBrushless);
	}

	public static Roller getInstance() {
		if (instance == null) {
			instance = new Roller();
		}
		return instance;
	}

	public void setRotationalSpeed(double rotationalSpeed) {
		motor.getPIDController().setReference(rotationalSpeed, CANSparkBase.ControlType.kVelocity);
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
