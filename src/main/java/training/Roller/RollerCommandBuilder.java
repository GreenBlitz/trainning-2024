package training.Roller;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;

import static training.Roller.RollerConstants.DEFAULT_ROLLING_TIME_SECONDS;

public class RollerCommandBuilder {

	private final Roller roller;

	public RollerCommandBuilder(Roller roller) {
		this.roller = roller;
	}

	public Command stop() {
		return new InstantCommand(roller::stop, roller);
	}

	public Command noteOut() {
		return rollForward().withTimeout(DEFAULT_ROLLING_TIME_SECONDS);
	}

	public Command rollBackward() {
		return new InstantCommand(roller::rollBackward, roller);
	}

	public Command rollForward() {
		return new InstantCommand(roller::rollForward, roller);
	}


}
