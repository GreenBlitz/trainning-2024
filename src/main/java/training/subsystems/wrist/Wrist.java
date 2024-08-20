package training.subsystems.wrist;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.math.geometry.Rotation2d;
import utils.GBSubsystem;

public class Wrist extends GBSubsystem {

	private static Wrist instance;
	private final CANSparkMax motor;

	private Wrist() {
		motor = new CANSparkMax(WristConstant.MOTOR_ID, CANSparkLowLevel.MotorType.kBrushless);
		motor.getPIDController().setP(WristConstant.P);
		motor.getPIDController().setI(WristConstant.I);
		motor.getPIDController().setD(WristConstant.D);
	}

	public static Wrist getInstance() {
		init();
		return instance;
	}

	public static void init() {
		if (instance == null) {
			instance = new Wrist();
		}
	}

	public void goToAngle(Rotation2d targetAngle) {
		motor.getPIDController().setReference(targetAngle.getDegrees(), CANSparkBase.ControlType.kPosition);
	}

	public boolean isAtAngle(Rotation2d targetAngle) {
		return Math.abs(targetAngle.getDegrees() - motor.getEncoder().getPosition()) == 0;
	}

	public void stop() {
		motor.set(0);
	}

	@Override
	protected String getLogPath() {
		return "Wrist/";
	}

	@Override
	protected void subsystemPeriodic() {
	}

}