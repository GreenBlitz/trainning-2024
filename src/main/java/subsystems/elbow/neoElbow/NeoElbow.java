package subsystems.elbow.neoElbow;

import com.revrobotics.CANSparkMax;
import edu.wpi.first.math.geometry.Rotation2d;
import subsystems.RobotConstants;
import subsystems.elbow.ElbowConstants;
import subsystems.elbow.IElbow;
import utils.GBSubsystem;

public class NeoElbow extends GBSubsystem implements IElbow {

	private static NeoElbow instance;
	private static CANSparkMax motor;

	private NeoElbow() {
		motor = new CANSparkMax(NeoElbowConstants.MOTOR_ID, RobotConstants.MOTOR_BRUSHLESS_TYPE);
		motor.getPIDController().setP(ElbowConstants.KP);
		motor.getPIDController().setI(ElbowConstants.KI);
		motor.getPIDController().setD(ElbowConstants.KD);
	}

	public static NeoElbow getInstance() {
		if (instance == null) {
			instance = new NeoElbow();
		}
		return instance;
	}

	public Rotation2d getAngle() {
		return Rotation2d.fromRotations(motor.getEncoder().getPosition() % 1);
	}

	public double getRPMVelocity() {
		return motor.getEncoder().getVelocity();
	}

	@Override
	public void setPower(double power) {
		motor.set(power);
	}

	private double calculateFeedForward() {
		return NeoElbowConstants.FEED_FORWARD.calculate(getAngle().getRadians(), getRPMVelocity());
	}

	public void goToPosition(Rotation2d position) {
		motor.getPIDController()
			.setReference(
				position.getRadians(),
				RobotConstants.PID_POSITION_CONTROL_TYPE,
				NeoElbowConstants.PID_SLOT,
				calculateFeedForward()
			);
	}

	@Override
	protected String getLogPath() {
		return "";
	}

	@Override
	protected void subsystemPeriodic() {}

}
