package training.subsystems.RobotArm.roller;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.math.geometry.Rotation2d;
import training.subsystems.RobotArm.elbow.ElbowConstants;
import training.subsystems.RobotArm.elbow.ElbowInputsAutoLogged;
import training.subsystems.RobotArm.wrist.WristConstans;
import utils.GBSubsystem;

public class Roller extends GBSubsystem {
	private RollerInputsAutoLogged inputs;
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

	public void moveAtSpeed(double velocity) {
		motor.getPIDController().setReference(velocity, CANSparkBase.ControlType.kVelocity, RollerConstants.PID_SLOT);
	}


	public Rotation2d getVelocity() {
		return Rotation2d.fromDegrees(motor.getEncoder().getVelocity());
	}


	public boolean isAtSpeed(Rotation2d velocity) {
		return (Math.abs(getVelocity().minus(velocity).getDegrees()) <= RollerConstants.TOLERANCE.getDegrees());
	}

	protected String getLogPath() {
		return "Roller/";
	}

	protected void subsystemPeriodic() {}

}
