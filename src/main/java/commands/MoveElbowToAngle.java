package commands;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import subsystems.elbow.Elbow;

public class MoveElbowToAngle extends Command {

	private final Rotation2d angle;
	private final Elbow elbow;

	public MoveElbowToAngle(Rotation2d angle) {
		elbow = Elbow.getInstance();
		addRequirements(elbow);

		this.angle = angle;
	}

	@Override
	public void execute() {
		elbow.goToPosition(angle);
	}

}
