package training.subsystems.ArmSubsystems.elbow;

import edu.wpi.first.math.geometry.Rotation2d;
import utils.GBSubsystem;

public class Elbow extends GBSubsystem {

	private final IElbow iElbow;
	private final ElbowInputsAutoLogged inputs;

	public Elbow() {
		this.iElbow = ElbowFactory.create();
		this.inputs = new ElbowInputsAutoLogged();
	}

	@Override
	protected String getLogPath() {
		return "Elbow/";
	}

	@Override
	protected void subsystemPeriodic() {}

	public static Rotation2d angleDistance(Rotation2d currentAngle, Rotation2d targetAngle) {
		return currentAngle.minus(targetAngle);
	}

	public boolean isAtTargetPosition(Rotation2d targetAngle, Rotation2d tolerance) {
		return Math.abs(angleDistance(inputs.position, targetAngle).getDegrees()) <= tolerance.getDegrees();
	}

	public void goToPosition(Rotation2d targetPosition) {
		iElbow.goToPosition(targetPosition);
	}

	public void stayAtPosition() {
		goToPosition(inputs.position);
	}

	public void setVoltage(double voltage) {
		iElbow.setVoltage(voltage);
	}

	public void setPower(double power) {
		iElbow.setPower(power);
	}


}
