package training.subsystems.elbow;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.geometry.Rotation2d;
import utils.GBSubsystem;

public class Elbow extends GBSubsystem {

	private static Elbow instance;
	private final CANSparkMax motor;
	private final ArmFeedforward armFeedforward;

	private Elbow() {
		this.armFeedforward = ElbowConstants.ARM_FEEDFORWARD;
		this.motor = new CANSparkMax(ElbowConstants.MOTOR_ID, CANSparkLowLevel.MotorType.kBrushless);
		motor.getPIDController().setP(ElbowConstants.P);
		motor.getPIDController().setI(ElbowConstants.I);
		motor.getPIDController().setD(ElbowConstants.D);
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

	public Rotation2d getPosition() {
		return Rotation2d.fromRotations(motor.getEncoder().getPosition());
	}

	public Rotation2d getVelocity() {
		return Rotation2d.fromRotations(motor.getEncoder().getVelocity());
	}

	public void goToAngle(Rotation2d targetAngle) {
		motor.getPIDController()
			.setReference(
				targetAngle.getDegrees(),
				CANSparkBase.ControlType.kPosition,
				ElbowConstants.PID_SLOT,
				ElbowConstants.ARM_FEEDFORWARD.calculate(getPosition().getRadians(), getVelocity().getRotations())
			);
	}

	public boolean isAtAngle(Rotation2d targetAngle) {
		return Math.abs(targetAngle.getDegrees() - motor.getEncoder().getPosition()) == 0;
	}

	public void stayAtPosition() {
		goToAngle(getPosition());
	}

	@Override
	protected String getLogPath() {
		return "Elbow/";
	}

	@Override
	protected void subsystemPeriodic() {
	}

}