package training.Wrist;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;

public class WristCommandBuilder {

	private final Wrist wrist;

	public WristCommandBuilder() {
		this.wrist = new Wrist();
	}

	public Command moveUpWrist() {
		return new InstantCommand(() -> wrist.rotate(WristDirection.kLeft), wrist);
	}

	public Command moveDownWrist() {
		return new InstantCommand(() -> wrist.rotate(WristDirection.kRight), wrist);
	}

}
