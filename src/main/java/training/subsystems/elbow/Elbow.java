package training.subsystems.elbow;

import edu.wpi.first.math.geometry.Rotation2d;
import utils.GBSubsystem;

public class Elbow extends GBSubsystem {

	private static Elbow instance;

	private final IElbow elbow;

	private Elbow() {
		this.elbow = ElbowFactory.create();
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
		return elbow.getPosition();
	}

	public Rotation2d getVelocity() {
		return elbow.getVelocity();
	}

	public void goToAngle(Rotation2d targetAngle) {
		elbow.goToAngle(targetAngle);
	}

	public boolean isAtAngle(Rotation2d targetAngle) {
		return Math.abs(targetAngle.getRotations() - elbow.getPosition().getRotations()) <= ElbowConstants.TOLERANCE.getRotations();
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