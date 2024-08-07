package training.subsystems.roller;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.math.geometry.Rotation2d;
import training.subsystems.elbow.Elbow;
import training.subsystems.elbow.ElbowConstants;
import utils.GBSubsystem;

public class Roller extends GBSubsystem {

	private CANSparkMax motor;
	private static Roller instance;
	private Roller() {
		motor = new CANSparkMax(RollerConstants.MOTOR_ID, CANSparkLowLevel.MotorType.kBrushless);
		motor.getPIDController().setP(RollerConstants.MOTOR_ID_P);
		motor.getPIDController().setI(RollerConstants.MOTOR_ID_I);
		motor.getPIDController().setD(RollerConstants.MOTOR_ID_D);
	}


	public static void init() {
		if (instance == null) {
			instance = new Roller();
		}
	}

	public void goToAngel(Rotation2d targetAngle) {
		motor.getPIDController().setReference(targetAngle.getDegrees(), CANSparkBase.ControlType.kPosition);
	}

	public static Roller getInstance() {
		init();
		return instance;
	}
	public void stop() {
		motor.set(0);
	}
	public boolean isAtAngle(Rotation2d targetAngle) {
		return Math.abs(targetAngle.getDegrees() - motor.getEncoder().getPosition()) == 0;
	}

	@Override
	protected String getLogPath() {
		return null;
	}

	@Override
	protected void subsystemPeriodic() {}

}








