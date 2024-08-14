package training.Elbow;

import edu.wpi.first.math.geometry.Rotation2d;
import org.littletonrobotics.junction.Logger;
import utils.GBSubsystem;

public class Elbow extends GBSubsystem {

	private final IElbow iElbow;
	private final ElbowCommandBuilder commandBuilder;
	private final ElbowInputsAutoLogged inputs;
	private Rotation2d targetAngle;

	public Elbow() {
		this.iElbow = new ElbowFactory().create();
		this.targetAngle = ElbowConstants.DEFAULT_POSITION;
		this.commandBuilder = new ElbowCommandBuilder(this);
		this.inputs = new ElbowInputsAutoLogged();
	}

	public ElbowCommandBuilder getCommandBuilder() {
		return commandBuilder;
	}

	protected void LockElbowInPlace() {
		targetAngle = getCurrentAngle();
	}

	public Rotation2d getCurrentAngle() {
		return inputs.position;
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
		double anglesDelta = (inputs.position.getDegrees() % 360) - (angle.getDegrees() % 360);
		return Math.abs(anglesDelta) <= ElbowConstants.TOLERANCE.getDegrees();
	}

	public boolean isAtTargetAngle() {
		return isAtAngle(targetAngle);
	}

	@Override
	protected String getLogPath() {
		return ElbowConstants.LOG_PATH;
	}

	@Override
	protected void subsystemPeriodic() {
		iElbow.moveToAngle(targetAngle);
		iElbow.updateInputs(inputs);
		Logger.recordOutput("Elbow/targetAngle: ", targetAngle);
		Logger.processInputs("RealOutputs/Elbow/inputs: ", inputs);
	}

}
