package training.subsystems.elbow;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.geometry.Rotation2d;
import utils.GBSubsystem;

public class Elbow extends GBSubsystem {

	private static Elbow instance;

	private final IElbow current;

	private Elbow() {
		this.current = ElbowFactory.create();

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
		return current.getPosition();
	}

	public Rotation2d getVelocity() {
		return current.getVelocity();
	}

	public void goToAngle(Rotation2d targetAngle) {
		current.goToAngle(targetAngle);
	}

	public boolean isAtAngle(Rotation2d targetAngle) {
		return Math.abs(targetAngle.getRotations() - current.getPosition().getRotations()) <= ElbowConstants.TOLERANCE.getRotations();
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