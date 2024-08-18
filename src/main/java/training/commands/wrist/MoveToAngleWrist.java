package training.commands.wrist;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import training.subsystems.wrist.Wrist;

public class MoveToAngleWrist extends Command {

	private Rotation2d targetAngle;

	public MoveToAngleWrist(Rotation2d targetAngle) {
		this.targetAngle = targetAngle;
	}

	@Override
	public void initialize() {
		Wrist.goToAngle(targetAngle);
	}

	public boolean isFinished() {
		return Wrist.getInstance().isAtAngle(targetAngle);
	}

	public void end(boolean interrupted) {
		Wrist.getInstance().stop();
	}

}

