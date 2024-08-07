package training.subsystems.arm.elbow;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.FunctionalCommand;

public class CommandsBuilder {

	private final Elbow elbow;

	public CommandsBuilder(Elbow elbow) {
		this.elbow = elbow;
	}

	public Command moveToPosition(Rotation2d angle) {
		return new FunctionalCommand(
			() -> elbow.moveToAngle(angle),
			() -> {},
			interrupted -> elbow.stayInPlace(),
			() -> elbow.isAtAngle(angle)
		);
	}

}
