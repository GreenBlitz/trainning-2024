package training.commands.roller;

import edu.wpi.first.wpilibj2.command.Command;
import training.subsystems.RobotArm.roller.Roller;

public class MoveRollerAtSpeed extends Command {

	private double velocity;

	public MoveRollerAtSpeed(double velocity) {
		this.velocity = velocity;
	}

	public void initialize() {
		super.initialize();
	}

	public void execute() {
		Roller.getInstance().moveAtSpeed(velocity);
	}

	public boolean isFinished() {
		return false;
	}

	public void end(boolean interrupted) {
		Roller.getInstance().moveAtSpeed(0);
	}

}
