package training.Elbow;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.FunctionalCommand;


public class ElbowCommandBuilder {

	private final Elbow elbow;

	public ElbowCommandBuilder(Elbow elbow) {
		this.elbow = elbow;
	}


	public Command moveToAngle(Rotation2d targetAngle) {
		return new FunctionalCommand(
			() -> {},
			() -> elbow.setTargetAngle(targetAngle),
			(interrupted) -> {},
			elbow::isAtTargetAngle,
			elbow
		);
	}

	public Command moveUpAndDown() {
		return new SequentialCommandGroup(moveUp(), new WaitCommand(ElbowConstants.DEFAULT_TIME_IN_AIR_SECONDS), moveDown());
	}

	public Command moveUpAndDown(double timeInAirSeconds) {
		return new SequentialCommandGroup(moveUp(), new WaitCommand(timeInAirSeconds), moveDown());
	}

	public Command standInPlace() {
		return new InstantCommand(elbow::LockElbowInPlace, elbow);
	}

	public Command moveUp() {
		return moveToAngle(ElbowConstants.LIFTING_POSITION);
	}

	public Command moveDown() {
		return moveToAngle(ElbowConstants.DEFAULT_POSITION);
	}

}
