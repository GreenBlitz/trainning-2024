package training.subsystems.ArmSubsystems.elbow;

import edu.wpi.first.math.geometry.Rotation2d;
import org.littletonrobotics.junction.Logger;
import utils.GBSubsystem;

public class Elbow extends GBSubsystem {

	private final IElbow iElbow;
	private final ElbowInputsAutoLogged inputs;
	private Rotation2d targetPosition = ElbowConstants.STARTING_POSITION;

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
		// iElbow.updateInputs(inputs);
		Logger.recordOutput("Elbow/Elbow position", getPosition().getDegrees());
		Logger.recordOutput("Elbow/Forward limit", ElbowConstants.FORWARD_ANGLE_LIMIT.getDegrees());
		Logger.recordOutput("Elbow/Backward limit", ElbowConstants.BACKWARD_ANGLE_LIMIT.getDegrees());
	}

	public static Rotation2d angleDistance(Rotation2d currentAngle, Rotation2d targetAngle) {
		return currentAngle.minus(targetAngle);
	}

	public boolean isAtTargetPosition() {
		return Math.abs(angleDistance(inputs.position, targetPosition).getDegrees())
			<= ElbowConstants.POSITION_TOLERANCE.getDegrees();
	}

	public boolean isStill() {
		return Math.abs(inputs.velocity.getRotations()) <= ElbowConstants.VELOCITY_TOLERANCE.getRotations();
	}

	public void goToPosition(Rotation2d targetPosition) {
		setTargetPosition(targetPosition);
		iElbow.goToPosition(getTargetPosition());
		Logger.recordOutput("Elbow/targetPosition:", targetPosition.getDegrees());
	}

	public void stayInPosition(Rotation2d targetPosition) {
		iElbow.goToPosition(targetPosition);
	}

	public void setVoltage(double voltage) {
		iElbow.setVoltage(voltage);
	}

	public void setPower(double power) {
		iElbow.setPower(power);
	}

	public void setPosition(Rotation2d position) {
		iElbow.setPosition(position);
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
		return targetPosition;
	}

	public void setTargetPosition(Rotation2d targetPosition) {
		this.targetPosition = targetPosition;
	}

}
