package training.commands.ArmCommands.elbowCommands;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import training.subsystems.ArmSubsystems.elbow.Elbow;


public class MoveElbow extends Command {

	private final Elbow elbow;
	private final Rotation2d targetPosition;

	public MoveElbow(Rotation2d targetPosition, Elbow elbow) {
		this.elbow = elbow;
		this.targetPosition = targetPosition;
		addRequirements(elbow);
	}

	@Override
	public void initialize() {}

	@Override
	public void execute() {
		elbow.goToPosition(targetPosition);
	}

	@Override
	public boolean isFinished() {
		return elbow.isAtTargetPosition() && elbow.isAtTargetVelocity();
	}


}
