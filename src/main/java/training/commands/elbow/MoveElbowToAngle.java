package training.commands.elbow;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import training.subsystems.RobotArm.elbow.Elbow;

public class MoveElbowToAngle extends Command {

	private Rotation2d position;

	public MoveElbowToAngle(Rotation2d position) {
		this.position = position;
	}

	@Override
	public void execute() {
		Elbow.getInstance().goToPosition(position);
	}

	@Override
	public boolean isFinished() {
		return false;
	}

	@Override
	public void end(boolean interrupted) {
		super.end(interrupted);
	}

}

