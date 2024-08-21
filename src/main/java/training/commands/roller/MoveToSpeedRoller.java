package training.commands.roller;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import training.subsystems.roller.Roller;

public class MoveToSpeedRoller extends Command {

	private double targetSpeed;
	private Roller roller;

	public void MoveToSpeedSpeed(double targetSpeed) {
		this.targetSpeed = targetSpeed;
	}

	public boolean isFinished() {
		return roller.isAtVelocity(Rotation2d.fromRotations(targetSpeed));
	}

	public void end(boolean interrupted) {
		roller.stop();
	}

}