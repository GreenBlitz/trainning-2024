package training.commands.Arm.Roller;

import edu.wpi.first.wpilibj2.command.Command;
import training.subsystems.Arm.Roller.Roller;

public class RollCounterClockwise extends Command {

	private final Roller roller;

	public RollCounterClockwise() {
		this.roller = Roller.getInstance();
	}

	@Override
	public void initialize() {
		roller.rollCounterClockwise();
	}

	@Override
	public void end(boolean interrupted) {
		roller.stop();
	}

}
