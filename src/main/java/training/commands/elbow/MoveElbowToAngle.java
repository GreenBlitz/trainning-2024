package training.commands.elbow;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import training.subsystems.elbow.Elbow;

public class MoveElbowToAngle extends Command {

	private Rotation2d targetAngle;

	public Elbow getInstance() {
		return Elbow.getInstance();
	}

	public MoveElbowToAngle(Rotation2d targetAngle) {
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
		getInstance().stayAtPosition();
	}

}