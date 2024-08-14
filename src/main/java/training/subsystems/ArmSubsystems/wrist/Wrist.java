package training.subsystems.ArmSubsystems.wrist;

import edu.wpi.first.math.geometry.Rotation2d;
import utils.GBSubsystem;

public class Wrist extends GBSubsystem {

	private final IWrist iWrist;
	private final WristInputsAutoLogged inputs;

	public Wrist() {
		iWrist = WristFactory.create();
		inputs = new WristInputsAutoLogged();
	}

	@Override
	protected String getLogPath() {
		return "Wrist/";
	}

	@Override
	protected void subsystemPeriodic() {
		updateInputs();
	}

	public void goToPosition(Rotation2d targetPosition) {
		iWrist.goToPosition(targetPosition);
	}

	public void updateInputs() {
		iWrist.updateInputs(inputs);
	}

	public void setPower(double power) {
		iWrist.setPower(power);
	}

	public void stopMotor() {
		setPower(0);
	}

	public Rotation2d getPosition() {
		return inputs.position;
	}

	public Rotation2d getVelocity() {
		return inputs.velocity;
	}

	public static Rotation2d angleDistance(Rotation2d currentAngle, Rotation2d targetAngle) {
		return currentAngle.minus(targetAngle);
	}

	public boolean isAtTargetAngle(Rotation2d targetAngle, Rotation2d positionTolerance) {
		return Math.abs(angleDistance(inputs.position, targetAngle).getDegrees()) <= positionTolerance.getDegrees();
	}

}
