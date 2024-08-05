package training.commands.ArmCommands.rollerCommands;

import edu.wpi.first.wpilibj2.command.Command;
import training.subsystems.ArmSubsystems.rollerSubsystem.Roller;

public class RollClockwise extends Command {

	private final Roller roller;

	public RollClockwise() {
		this.roller = Roller.getInstance();
	}

	public void initialize() {
		roller.rollClockwise();
	}

	public void end(boolean interrupted) {
		roller.stop();
	}

}
