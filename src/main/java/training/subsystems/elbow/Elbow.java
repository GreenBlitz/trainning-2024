package training.subsystems.elbow;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.math.geometry.Rotation2d;
import utils.GBSubsystem;

public class Elbow extends GBSubsystem {

	private static CANSparkMax motor;
	private static Elbow instance;

	private Elbow() {
		motor = new CANSparkMax(ElbowConstants.MOTOR_ID, CANSparkLowLevel.MotorType.kBrushless);
		motor.getPIDController().setP(ElbowConstants.MOTOR_ID_P);
		motor.getPIDController().setI(ElbowConstants.MOTOR_ID_I);
		motor.getPIDController().setD(ElbowConstants.MOTOR_ID_D);
	}

	public static void init() {
		if (instance == null) {
			instance = new Elbow();
		}
	}

	public static Elbow getInstance() {
		init();
		return instance;
	}

	public static void goToAngel(Rotation2d targetAngle) {
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
		return "Elbow";
	}

	@Override
	protected void subsystemPeriodic() {}

}
