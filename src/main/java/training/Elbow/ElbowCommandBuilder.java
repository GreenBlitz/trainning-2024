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
			() -> elbow.isAtAngle(targetAngle),
			elbow
		);
	}

	public Command moveUpAndDown() {
		return new SequentialCommandGroup(
			moveUp(),
			new WaitCommand(ElbowConstants.DEFAULT_TIME_IN_AIR_ELBOW_SECONDS),
			moveDown()
		);
	}

	public Command moveUpAndDown(double timeInAirSeconds) { // i know there is a Time object in wpilib, i'll change that
																	// later
		return new SequentialCommandGroup(moveUp(), new WaitCommand(timeInAirSeconds), moveDown());
	}

	public Command standInPlace() {
		return new InstantCommand(elbow::LockElbowInPlace, elbow);
	}

	public Command moveUp() {
		return moveToAngle(ElbowConstants.LIFTING_POSITION_DEGREES);
	}

	public Command moveDown() {
		return moveToAngle(ElbowConstants.LIFTING_POSITION_DEGREES.times(-1));
	}

}
