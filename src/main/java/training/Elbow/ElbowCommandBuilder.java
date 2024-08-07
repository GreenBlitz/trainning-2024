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


	public Command moveElbowToAngle(Rotation2d targetAngle) {
		return new FunctionalCommand(
			() -> {},
			() -> elbow.setTargetAngle(targetAngle),
			(interrupted) -> {},
			() -> elbow.isAtAngle(targetAngle),
			elbow
		);
	}

	public Command moveElbowUpAndDown() {
		return new SequentialCommandGroup(
			upElbow(),
			new WaitCommand(ElbowConstants.DEFAULT_TIME_IN_AIR_ELBOW_SECONDS),
			downElbow()
		);
	}

	public Command moveElbowUpAndDown(double timeInAirSeconds) { // i know there is a Time object in wpilib, i'll change that
																	// later
		return new SequentialCommandGroup(upElbow(), new WaitCommand(timeInAirSeconds), downElbow());
	}

	public Command elbowStandInPlace() {
		return new InstantCommand(elbow::LockElbowInPlace, elbow);
	}

	public Command upElbow() {
		return moveElbowToAngle(ElbowConstants.LIFTING_POSITION_DEGREES);
	}

	public Command downElbow() {
		return moveElbowToAngle(ElbowConstants.LIFTING_POSITION_DEGREES.times(-1));
	}

}
