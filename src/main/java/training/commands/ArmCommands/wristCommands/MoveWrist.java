package training.commands.ArmCommands.wristCommands;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import training.subsystems.ArmSubsystems.wrist.Wrist;
import training.subsystems.ArmSubsystems.wrist.WristConstants;

public class MoveWrist extends Command {

	private final Wrist wrist;
	private final Rotation2d targetPosition;

	public MoveWrist(Rotation2d targetPosition, Wrist wrist) {
		this.wrist = wrist;
		this.targetPosition = targetPosition;
	}

	@Override
	public void initialize() {
		wrist.goToPosition(targetPosition);
	}

	@Override
	public boolean isFinished() {
		return wrist.isAtTargetAngle(targetPosition, WristConstants.TOLERANCE);
	}

}