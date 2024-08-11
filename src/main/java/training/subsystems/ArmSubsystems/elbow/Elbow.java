package training.subsystems.ArmSubsystems.elbow;

import edu.wpi.first.math.geometry.Rotation2d;
import org.littletonrobotics.junction.Logger;
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
	protected void subsystemPeriodic() {
		iElbow.updateInputs(inputs);
		Logger.recordOutput("Elbow position", getPosition().getDegrees());
		Logger.recordOutput("Forward limit", ElbowConstants.FORWARD_ANGLE_LIMIT.getDegrees());
		Logger.recordOutput("Backward limit", ElbowConstants.BACKWARD_ANGLE_LIMIT.getDegrees());
	}

	public static Rotation2d angleDistance(Rotation2d currentAngle, Rotation2d targetAngle) {
		return currentAngle.minus(targetAngle);
	}

	public boolean isAtTargetPosition(Rotation2d targetAngle, Rotation2d positionTolerance, Rotation2d velocityTolerance) {
		return Math.abs(angleDistance(inputs.position, targetAngle).getDegrees()) <= positionTolerance.getDegrees()
			&& inputs.velocity.getRotations() <= velocityTolerance.getRotations();
	}

	public void goToPosition(Rotation2d targetPosition) {
		iElbow.goToPosition(inputs.targetPosition);
		Logger.recordOutput("target position:", targetPosition.getDegrees());
		setTargetPosition(targetPosition);
	}

	public void stayAtPosition() {
		goToPosition(inputs.targetPosition);
	}

	public void setVoltage(double voltage) {
		iElbow.setVoltage(voltage);
	}

	public void setPower(double power) {
		iElbow.setPower(power);
	}

	public Rotation2d getVelocity() {
		return inputs.velocity;
	}

	public Rotation2d getPosition() {
		return inputs.position;
	}

	public double getVoltage() {
		return inputs.voltage;
	}

	public double getCurrent() {
		return inputs.current;
	}

	public Rotation2d getTargetPosition() {
		return inputs.targetPosition;
	}

	public void setTargetPosition(Rotation2d targetPosition) {
		inputs.targetPosition = targetPosition;
	}

}