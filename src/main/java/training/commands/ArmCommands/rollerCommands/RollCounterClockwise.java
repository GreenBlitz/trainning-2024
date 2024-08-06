package training.commands.ArmCommands.rollerCommands;

import edu.wpi.first.wpilibj2.command.Command;
import training.subsystems.ArmSubsystems.rollerSubsystem.Roller;

public class RollCounterClockwise extends Command {

	private final Roller roller;

	public RollCounterClockwise(Roller roller) {
		this.roller = roller;
	}

	public void initialize() {
		roller.rollCounterClockwise();
	}

	public void end(boolean interrupted) {
		roller.stop();
	}

}
