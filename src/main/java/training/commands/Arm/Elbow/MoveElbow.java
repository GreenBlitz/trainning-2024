package training.commands.Arm.Elbow;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import org.littletonrobotics.junction.Logger;
import training.subsystems.Arm.Elbow.Elbow;

public class MoveElbow extends Command {

	private final Elbow elbow;

	private final Rotation2d targetPosition;

	public MoveElbow(Elbow elbow, Rotation2d targetPosition) {
		this.elbow = elbow;
		this.targetPosition = targetPosition;
	}

	@Override
	public void initialize() {
		elbow.moveToPosition(targetPosition);
		Logger.recordOutput("MoveEloSta", "at position" + elbow.getPosition());
	}

	@Override
	public boolean isFinished() {
		return elbow.isAtPosition(targetPosition);
	}

	@Override
	public void end(boolean interrupted) {
		elbow.stayAtPosition();
		Logger.recordOutput("MoveEloEnd", "at position" + elbow.getPosition());
	}

}
