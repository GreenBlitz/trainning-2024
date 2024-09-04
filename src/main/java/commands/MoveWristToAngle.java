package commands;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import subsystems.wrist.Wrist;

public class MoveWristToAngle extends Command {

	private final Rotation2d angle;
	private final Wrist wrist;

	public MoveWristToAngle(Rotation2d angle) {
		this.wrist = Wrist.getInstance();
		this.angle = angle;

		addRequirements(wrist);
	}

	@Override
	public void execute() {
		wrist.goToPosition(angle);
	}

	@Override
	public boolean isFinished() {
		return wrist.isAtAngle(angle);
	}

}
