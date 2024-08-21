package training.subsystems.RobotArm.roller;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.math.geometry.Rotation2d;
import utils.GBSubsystem;

public class Roller extends GBSubsystem {

	private CANSparkMax motor;
	private static Roller instance;

	private Roller() {
		this.motor = new CANSparkMax(RollerConstants.MOTOR_ID, CANSparkLowLevel.MotorType.kBrushless);
		motor.getPIDController().setP(RollerConstants.KP);
		motor.getPIDController().setI(RollerConstants.KI);
		motor.getPIDController().setD(RollerConstants.KD);
	}

	public static Roller getInstance() {
		if (instance != null)
			instance = new Roller();
		return instance;
	}

	public void moveAtSpeed(Rotation2d velocity) {
		motor.getPIDController().setReference(velocity, CANSparkBase.ControlType.kVelocity, RollerConstants.PID_SLOT);
	}


	public Rotation2d getPower() {
		return Rotation2d.fromDegrees(motor.getEncoder().getPosition());
	}

	public boolean isAtSpeed(Rotation2d velocity) {
		return (getPower() == velocity);
	}

	protected String getLogPath() {
		return "Roller/";
	}


	protected void subsystemPeriodic() {}

}
