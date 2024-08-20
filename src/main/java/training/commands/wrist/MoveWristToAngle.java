package training.commands.wrist;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import training.subsystems.wrist.Wrist;

public class MoveWristToAngle extends Command {

	private Rotation2d targetAngle;

	public Wrist getInstance() {
		return Wrist.getInstance();
	}

	public MoveWristToAngle(Rotation2d targetAngle) {
		this.targetAngle = targetAngle;
	}

	@Override
	public void initialize() {
		getInstance().goToAngle(targetAngle);
	}

	public boolean isFinished() {
		return getInstance().isAtAngle(targetAngle);
	}

	public void end(boolean interrupted) {
		getInstance().stop();
	}

}