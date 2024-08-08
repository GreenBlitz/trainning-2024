package training.commands.Arm.Roller;

import edu.wpi.first.wpilibj2.command.Command;
import training.subsystems.Arm.Roller.Roller;

public class RollClockwise extends Command {

	private final Roller roller;

	public RollClockwise(Roller roller) {
		this.roller = Roller.getInstance();
	}

	@Override
	public void initialize() {
		roller.rollClockwise();
	}

	@Override
	public void end(boolean interrupted) {
		roller.stop();
	}

}
