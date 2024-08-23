package training.commands.roller;

import edu.wpi.first.wpilibj2.command.Command;
import training.subsystems.roller.Roller;

public class MoveRollerToSpeed extends Command {

	private double targetSpeed;
	private Roller roller;

	public MoveRollerToSpeed(double targetSpeed) {
		this.targetSpeed = targetSpeed;
		this.roller = Roller.getInstance();
		addRequirements(roller);
	}

	@Override
	public void execute() {
		roller.goToSpeed(targetSpeed);
	}

	public void end(boolean interrupted) {
		roller.stop();
	}

}
