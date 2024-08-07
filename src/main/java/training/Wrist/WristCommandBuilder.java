package training.Wrist;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;

public class WristCommandBuilder {

	private final Wrist wrist;

	public WristCommandBuilder(Wrist wrist) {
		this.wrist = wrist;
	}

	public Command moveUp() {
		return new InstantCommand(() -> wrist.rotate(WristDirection.kLeft), wrist);
	}

	public Command moveDown() {
		return new InstantCommand(() -> wrist.rotate(WristDirection.kRight), wrist);
	}

}
