package training.Elbow;

import edu.wpi.first.math.geometry.Rotation2d;
import utils.GBSubsystem;

public class Elbow extends GBSubsystem {

	private final IElbow iElbow;
	private final ElbowCommandBuilder commandBuilder;
	private Rotation2d targetAngle;

	public Elbow() {
		this.iElbow = new ElbowFactory().create();
		this.targetAngle = ElbowConstants.DEFAULT_POSITION_ELBOW;
		this.commandBuilder = new ElbowCommandBuilder(this);
	}

	public ElbowCommandBuilder getCommandBuilder() {
		return commandBuilder;
	}

	protected void LockElbowInPlace() {
		targetAngle = getCurrentAngle();
	}

	public Rotation2d getCurrentAngle() {
		return iElbow.getCurrentAngle();
	}

	public Rotation2d getTargetAngle() {
		return targetAngle;
	}

	public void setTargetAngle(Rotation2d targetAngle) {
		this.targetAngle = targetAngle;
	}

	protected void addToAngle(Rotation2d angle) {
		this.targetAngle = this.targetAngle.plus(angle);
	}

	protected void subtractFromAngle(Rotation2d angle) {
		this.targetAngle = this.targetAngle.minus(angle);
	}

	public boolean isAtAngle(Rotation2d angle) {
		double anglesDelta = (this.targetAngle.getDegrees() % 360) - (angle.getDegrees() % 360);
		return Math.abs(anglesDelta) <= ElbowConstants.ELBOW_TOLERANCE.getDegrees();
	}

	@Override
	protected String getLogPath() {
		return ElbowConstants.ELBOW_LOG_PATH;
	}

	@Override
	protected void subsystemPeriodic() {
		iElbow.moveToAngle(targetAngle);
	}


}
