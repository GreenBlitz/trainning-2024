package training.commands.elbow;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import training.subsystems.elbow.Elbow;

public class MoveElbowToAngle extends Command {

	private Rotation2d targetAngle;
	private Elbow elbow;

	public MoveElbowToAngle(Rotation2d targetAngle) {
		this.targetAngle = targetAngle;
		this.elbow = Elbow.getInstance();
		addRequirements(this.elbow);
	}

	@Override
	public void execute() {
		elbow.goToAngle(targetAngle);
	}

	public boolean isFinished() {
		return elbow.isAtAngle(targetAngle);
	}

	public void end(boolean interrupted) {
		elbow.stayAtPosition();
	}

}