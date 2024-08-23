package training.commands.wrist;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import training.subsystems.roller.Roller;
import training.subsystems.wrist.Wrist;

public class MoveWristToAngle extends Command {

	private Rotation2d targetAngle;
	private Wrist wrist;

	public MoveWristToAngle(Rotation2d targetAngle) {
		this.targetAngle = targetAngle;
	}

	@Override
	public void initialize() {
		wrist.goToAngle(targetAngle);
	}

}