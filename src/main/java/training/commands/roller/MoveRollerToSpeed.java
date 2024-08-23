package training.commands.roller;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import training.subsystems.roller.Roller;

public class MoveRollerToSpeed extends Command {

	private double targetSpeed;
	private Roller roller;

	public MoveRollerToSpeed(double targetSpeed) {
		this.targetSpeed = targetSpeed;
		this.roller = Roller.getInstance();
	}

	@Override
	public void execute() {
		roller.goToSpeed(targetSpeed);
	}


}