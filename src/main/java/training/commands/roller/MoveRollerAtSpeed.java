package training.commands.roller;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import training.subsystems.RobotArm.roller.Roller;
import utils.joysticks.SmartJoystick;
public class MoveRollerAtSpeed extends Command {
private Roller roller;
	private Rotation2d velocity;

	public MoveRollerAtSpeed(Rotation2d velocity) {
		this.velocity = velocity;
	}

	public void initialize() {
		Roller.getInstance().moveAtSpeed(velocity.getDegrees());
	}

	public boolean isFinished() {
		return (velocity == roller.getPower());
	}

	public void end(boolean interrupted) {
 		roller.moveAtSpeed(0);
	}

}
