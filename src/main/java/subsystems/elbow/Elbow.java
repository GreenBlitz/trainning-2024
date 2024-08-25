package subsystems.elbow;

import edu.wpi.first.math.geometry.Rotation2d;
import utils.GBSubsystem;


public class Elbow extends GBSubsystem {

	private static Elbow instance;
	private IElbow iElbow;

	private Elbow() {
		this.iElbow = ElbowFactory.create();
	}

	public static Elbow getInstance() {
		if (instance == null) {
			instance = new Elbow();
		}
		return instance;
	}

	public void goToPosition(Rotation2d position) {
		iElbow.goToPosition(position);
	}

	public boolean isAtAngle(Rotation2d angle) {
		return Math.abs(iElbow.getAngle().getRadians() - angle.getRadians()) <= ElbowConstants.ANGLE_TOLERANCE.getRadians();
	}

	@Override
	protected String getLogPath() {
		return "ELBOW/";
	}

	@Override
	protected void subsystemPeriodic() {}

}
