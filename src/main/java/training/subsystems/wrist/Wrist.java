package training.subsystems.wrist;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.math.geometry.Rotation2d;
import training.subsystems.elbow.ElbowConstants;
import training.subsystems.roller.Roller;
import training.subsystems.roller.RollerConstants;
import utils.GBSubsystem;

public class Wrist extends GBSubsystem {

	private CANSparkMax motor;
	private static Wrist instance;

	private Wrist() {
		motor = new CANSparkMax(WristConstant.MOTOR_ID, CANSparkLowLevel.MotorType.kBrushless);
		motor.getPIDController().setP(WristConstant.MOTOR_ID_P);
		motor.getPIDController().setI(WristConstant.MOTOR_ID_I);
		motor.getPIDController().setD(WristConstant.MOTOR_ID_D);
	}

	public static void init() {
		if (instance == null) {
			instance = new Wrist();
		}
	}

	public boolean isAtAngle(Rotation2d targetAngle) {
		return Math.abs(targetAngle.getDegrees() - motor.getEncoder().getPosition()) == 0;
	}

	public static Wrist getInstance() {
		init();
		return instance;
	}
	public void stop() {
		motor.set(0);
	}
	public void goToAngel(Rotation2d targetAngle) {
		motor.getPIDController().setReference(targetAngle.getDegrees(), CANSparkBase.ControlType.kPosition);
	}


	@Override
	protected String getLogPath() {
		return "Wrist";
	}

	@Override
	protected void subsystemPeriodic() {}

}









