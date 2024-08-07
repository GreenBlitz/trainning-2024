package training.subsystems.Arm.Elbow;

import edu.wpi.first.math.geometry.Rotation2d;
import utils.GBSubsystem;

public class Elbow extends GBSubsystem {

	private IElbow iElbow;

	public Elbow() {
		this.iElbow = ElbowFactory.create();
	}

	@Override
	protected String getLogPath() {
		return null;
	}

	@Override
	protected void subsystemPeriodic() {}


	public void setPower(double power) {
		iElbow.setPower(power);
	}

	public boolean isAtPosition(Rotation2d target) {
		return Math.abs(iElbow.getPosition().getDegrees() - target.getDegrees()) <= ElbowConstants.TOLERANCE;
	}

	public void moveToPosition(Rotation2d targetPosition) {
		iElbow.moveToPosition(targetPosition);
	}

	public void stayAtPosition() {
		moveToPosition(iElbow.getPosition());
	}


}
