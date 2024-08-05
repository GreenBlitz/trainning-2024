package training.commands.Arm.Roller;

import edu.wpi.first.wpilibj2.command.Command;
import training.subsystems.Arm.Roller.Roller;

public class RollerCounterClockwise extends Command {

	private final Roller roller;

	public RollerCounterClockwise() {
		this.roller = Roller.getInstance();
	}

	@Override
	public void initialize() {
		roller.counterClockwise();
	}

	@Override
	public void end(boolean interrupted) {
		roller.stop();
	}

}
