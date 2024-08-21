package training.subsystems.ArmSubsystems.wrist;

import edu.wpi.first.math.geometry.Rotation2d;
import org.littletonrobotics.junction.Logger;
import utils.GBSubsystem;

public class Wrist extends GBSubsystem {

	private final IWrist iWrist;
	private final WristInputsAutoLogged inputs;
	private Rotation2d targetPosition = WristConstants.STARTING_POSITION;

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
		iWrist.updateInputs(inputs);
		Logger.processInputs("Wrist/wrist inputs:", inputs);
		Logger.recordOutput("Wrist/Wrist position: ", inputs.position);
		updateInputs();
	}

	public void goToPosition(Rotation2d targetPosition) {
		iWrist.goToPosition(targetPosition);
		Logger.recordOutput("Wrist/targetPosition:", targetPosition);
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

	public boolean isAtTargetPosition() {
		return Math.abs(angleDistance(inputs.position, targetPosition).getDegrees())
			<= WristConstants.POSITION_TOLERANCE.getDegrees();
	}

	public boolean isAtTargetVelocity() {
		return Math.abs(inputs.velocity.getRotations()) <= WristConstants.VELOCITY_TOLERANCE.getRotations();
	}

}
