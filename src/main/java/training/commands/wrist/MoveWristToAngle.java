package training.commands.wrist;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import training.subsystems.RobotArm.wrist.Wrist;

public class MoveWristToAngle extends Command {

	Wrist wristSubsystem = new Wrist();
	private Rotation2d wantedAngle;

	public MoveWristToAngle(Rotation2d wantedAngle) {
		this.wantedAngle = wantedAngle;
	}

	@Override
	public void initialize() {}

	@Override
	public void execute() {
		wristSubsystem.goToPosition(wantedAngle);
	}

	@Override
	public boolean isFinished() {
		return false;
	}

	@Override
	public void end(boolean interrupted) {}

}
