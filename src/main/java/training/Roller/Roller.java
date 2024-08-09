package training.Roller;

import edu.wpi.first.math.geometry.Rotation2d;
import utils.GBSubsystem;

import static training.Roller.RollerConstants.DEFAULT_VELOCITY;
import static training.Roller.RollerConstants.LOG_PATH;

public class Roller extends GBSubsystem {

	private final IRoller iRoller;
	private final RollerCommandBuilder commandBuilder;
	private final RollerInputsAutoLogged inputs;
	private Rotation2d targetVelocity;

	public Roller() {
		this.commandBuilder = new RollerCommandBuilder(this);
		this.iRoller = new RollerFactory().create();
		this.targetVelocity = Rotation2d.fromRotations(DEFAULT_VELOCITY.getRotations());
		this.inputs = new RollerInputsAutoLogged();
	}

	public RollerCommandBuilder getCommandBuilder() {
		return commandBuilder;
	}

	public Rotation2d getTargetVelocity() {
		return targetVelocity;
	}

	public Rotation2d getCurrentPosition() {
		return inputs.position;
	}

	public Rotation2d getCurrentVelocity() {
		return inputs.velocity;
	}

	public void setTargetVelocity(Rotation2d targetVelocity) {
		this.targetVelocity = targetVelocity;
	}

	protected void rollForward() {
		this.targetVelocity = Rotation2d.fromRotations(DEFAULT_VELOCITY.getRotations());
	}

	protected void rollBackward() {
		this.targetVelocity = Rotation2d.fromRotations(DEFAULT_VELOCITY.times(-1).getRotations());
	}

	protected void stop() {
		targetVelocity = Rotation2d.fromRotations(0);
		iRoller.setPower(0);
	}

	@Override
	protected String getLogPath() {
		return LOG_PATH;
	}

	@Override
	protected void subsystemPeriodic() {
		iRoller.updateVelocity(targetVelocity);
		iRoller.updateInputs(inputs);
	}

}
