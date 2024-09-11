package commands;

import edu.wpi.first.wpilibj2.command.Command;
import subsystems.Roller.Roller;

public class RotateRollerBySpeed extends Command {

	private final double rotationalSpeed;
	private final Roller roller;

	public RotateRollerBySpeed(double speed) {
		this.roller = Roller.getInstance();
		this.rotationalSpeed = speed;

		addRequirements(roller);
	}

	@Override
	public void execute() {
		roller.setRotationalSpeed(rotationalSpeed);
	}

	@Override
	public void end(boolean interrupted) {
		roller.setRotationalSpeed(0);
	}
}
