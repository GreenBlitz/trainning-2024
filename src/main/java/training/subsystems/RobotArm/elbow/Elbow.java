package training.subsystems.RobotArm.elbow;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.math.geometry.Rotation2d;
import utils.GBSubsystem;

public class Elbow extends GBSubsystem {

	private final CANSparkMax motor;
	private Rotation2d position;
	private static Elbow instance;

	private Elbow() {
		this.motor = new CANSparkMax(ElbowConstants.MOTOR_ID, CANSparkLowLevel.MotorType.kBrushless);
		this.position = new Rotation2d(ElbowConstants.BIGINNING_POSITION);
		motor.getPIDController().setP(ElbowConstants.KP);
		motor.getPIDController().setI(ElbowConstants.KI);
		motor.getPIDController().setD(ElbowConstants.KD);
	}


	public static Elbow getInstance() {
		if (instance != null)
			instance = new Elbow();
		return instance;
	}


	public void goToPosition(Rotation2d position) {
		motor.getPIDController()
			.setReference(
				position.getDegrees(),
				CANSparkBase.ControlType.kPosition,
				ElbowConstants.PID_SLOT,
				ElbowConstants.ARM_FEED_FORWARD.calculate(getPosition().getRadians(), getVelocity().getRotations())
			);
	}public Rotation2d getPosition() {
		return Rotation2d.fromDegrees(motor.getEncoder().getPosition());
	}

	public void stayInPlace(){
		goToPosition(getPosition());
	}

	public Rotation2d getVelocity() {
		return Rotation2d.fromDegrees(motor.getEncoder().getVelocity());
	}
	public boolean isAtPosition(Rotation2d position) {
		return (getPosition() == position);
	}
	@Override
	protected String getLogPath() {
		return "Elbow/";
	}
	@Override
	protected void subsystemPeriodic() {}

}

