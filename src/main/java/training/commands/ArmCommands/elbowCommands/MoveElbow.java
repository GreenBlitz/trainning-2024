package training.commands.ArmCommands.elbowCommands;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import training.subsystems.ArmSubsystems.elbow.Elbow;
import training.subsystems.ArmSubsystems.elbow.ElbowConstants;


public class MoveElbow extends Command {

	private final Elbow elbow;
	private final Rotation2d targetPosition;

	public MoveElbow(Rotation2d targetPosition, Elbow elbow) {
		this.elbow = elbow;
		this.targetPosition = targetPosition;
	}

	@Override
	public void execute() {
		elbow.goToPosition(targetPosition);
	}

	@Override
	public boolean isFinished() {
		return elbow.isAtTargetPosition(targetPosition, ElbowConstants.POSITION_TOLERANCE, ElbowConstants.VELOCITY_TOLERANCE)
			&& elbow.getVelocity().getRotations() <= ElbowConstants.VELOCITY_TOLERANCE.getRotations();
	}

}
