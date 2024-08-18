package training.subsystems.roller;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.math.geometry.Rotation2d;
import training.subsystems.elbow.Elbow;
import training.subsystems.elbow.ElbowConstants;
import utils.GBSubsystem;

public class Roller extends GBSubsystem {

	private static CANSparkMax motor;
	private static Roller instance;
	private Roller() {
		motor = new CANSparkMax(RollerConstants.MOTOR_ID, CANSparkLowLevel.MotorType.kBrushless);
		motor.getPIDController().setP(RollerConstants.MOTOR_P);
		motor.getPIDController().setI(RollerConstants.MOTOR_I);
		motor.getPIDController().setD(RollerConstants.MOTOR_D);
	}


	public static void init() {
		if (instance == null) {
			instance = new Roller();
		}
	}
	public boolean isAtVelocity(double targetVelocity) {
		return Math.abs(targetVelocity - motor.getEncoder().getVelocity()) == 0.0;
	}

	public void goToSpeed(double targetSpeed) {
		motor.getPIDController().setReference(targetSpeed, CANSparkBase.ControlType.kVelocity);
	}

	public static Roller getInstance() {
		init();
		return instance;
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








