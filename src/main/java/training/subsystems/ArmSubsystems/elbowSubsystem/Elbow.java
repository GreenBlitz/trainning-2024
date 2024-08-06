package training.subsystems.ArmSubsystems.elbowSubsystem;

import edu.wpi.first.math.geometry.Rotation2d;
import utils.GBSubsystem;

public class Elbow extends GBSubsystem {

	private final IElbow iElbow;
	private final ElbowInputsAutoLogged inputs;

	public Elbow() {
		this.iElbow = Factory.create();
		this.inputs = new ElbowInputsAutoLogged();
	}

	@Override
	protected String getLogPath() {
		return null;
	}

	@Override
	protected void subsystemPeriodic() {}

	public boolean isAtTargetPosition(Rotation2d targetAngle, Rotation2d tolerance) {
		return Math.abs(inputs.position.minus(targetAngle).getDegrees()) <= tolerance.getDegrees();
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
