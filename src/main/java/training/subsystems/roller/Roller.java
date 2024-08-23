package training.subsystems.roller;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.math.geometry.Rotation2d;
import org.littletonrobotics.junction.Logger;
import utils.GBSubsystem;

public class Roller extends GBSubsystem {

	private static Roller instance;
	private final CANSparkMax motor;

	private Roller() {
		motor = new CANSparkMax(RollerConstants.MOTOR_ID, CANSparkLowLevel.MotorType.kBrushless);
		motor.getPIDController().setP(RollerConstants.P);
		motor.getPIDController().setI(RollerConstants.I);
		motor.getPIDController().setD(RollerConstants.D);
	}

	public static void init() {
		if (instance == null) {
			instance = new Roller();
		}
	}

	public static Roller getInstance() {
		init();
		return instance;
	}

	public Rotation2d getVelocity() {
		return Rotation2d.fromRadians(motor.getEncoder().getVelocity());
	}

	public boolean isAtVelocity(Rotation2d targetVelocity) {
		return Math.abs(targetVelocity.getRotations() - motor.getEncoder().getVelocity()) <= RollerConstants.TOLERANCE.getRotations();
	}

	public void goToSpeed(double targetSpeed) {
		motor.getPIDController().setReference(targetSpeed, CANSparkBase.ControlType.kVelocity);
	}

	public Rotation2d getPosition() {
		return getInstance().getPosition();
	}

	public void stop() {
		motor.set(0);
	}

	@Override
	protected String getLogPath() {
		return "Roller/";
	}

	@Override
	protected void subsystemPeriodic() {
		Logger.recordOutput("Roller speed", getVelocity().getRotations());
	}

}