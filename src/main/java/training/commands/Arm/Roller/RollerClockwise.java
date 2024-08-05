package training.commands.Arm.Roller;

import edu.wpi.first.wpilibj2.command.Command;
import training.subsystems.Arm.Roller.Roller;

public class RollerClockwise extends Command {

	private final Roller roller;

	public RollerClockwise(Roller roller) {
		this.roller = Roller.getInstance();
	}

	@Override
	public void initialize() {
		roller.clockwise();
	}

	@Override
	public void end(boolean interrupted) {
		roller.stop();
	}

}
