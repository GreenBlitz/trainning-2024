package training.subsystems.ArmSubsystems.roller;

import edu.wpi.first.math.geometry.Rotation2d;
import utils.GBSubsystem;

public class Roller extends GBSubsystem {

	private final IRoller iRoller;
	private final RollerInputsAutoLogged inputs;

	public Roller() {
		this.iRoller = RollerFactory.create();
		this.inputs = new RollerInputsAutoLogged();
	}

	@Override
	protected String getLogPath() {
		return "Roller/";
	}

	@Override
	protected void subsystemPeriodic() {}

	public void rollClockwise() {
		iRoller.setPower(RollerConstants.DEFAULT_CLOCKWISE_POWER);
	}

	public void rollCounterClockwise() {
		iRoller.setPower(RollerConstants.DEFAULT_COUNTER_CLOCKWISE_POWER);
	}

	public void stop() {
		iRoller.setPower(0);
	}

	public Rotation2d getVelocity() {
		return inputs.velocity;
	}

	public Rotation2d getPosition() {
		return inputs.position;
	}

}
