package training.Wrist;

import edu.wpi.first.math.geometry.Rotation2d;
import org.littletonrobotics.junction.Logger;
import utils.GBSubsystem;

import static training.Wrist.WristConstants.*;

public class Wrist extends GBSubsystem {

	private final IWrist iWrist;
	private final WristCommandBuilder commandBuilder;
	private final WristInputsAutoLogged inputs;
	private Rotation2d targetAngle;

	public Wrist() {
		this.iWrist = WristFactory.create();
		this.commandBuilder = new WristCommandBuilder(this);
		this.inputs = new WristInputsAutoLogged();
		this.targetAngle = LOWER_POSITION;
	}

	public WristCommandBuilder getCommandBuilder() {
		return commandBuilder;
	}

	protected void stop() {
		targetAngle = new Rotation2d(0);
		iWrist.setPower(0);
	}

	protected void rotate(WristDirection direction) {
		targetAngle = direction.gotLeft() ? UPPER_POSITION : LOWER_POSITION;
	}

	@Override
	protected String getLogPath() {
		return LOG_PATH;
	}

	@Override
	protected void subsystemPeriodic() {
		iWrist.moveToAngle(targetAngle);
		iWrist.updateInputs(inputs);

		Logger.recordOutput(getLogPath() + "targetAngle", targetAngle);
		Logger.processInputs(getLogPath() + "inputs", inputs);
	}

}
