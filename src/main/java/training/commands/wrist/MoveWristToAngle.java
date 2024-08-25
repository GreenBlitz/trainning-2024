package training.commands.wrist;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import training.subsystems.RobotArm.wrist.Wrist;

public class MoveWristToAngle extends Command {

	private Wrist wristSubsystem;
	private Rotation2d wantedAngle;

	public MoveWristToAngle(Rotation2d wantedAngle,Wrist wristSubsystem) {
		this.wantedAngle = wantedAngle;
		this.wristSubsystem = wristSubsystem;
	}

	@Override
	public void initialize() {}

	@Override
	public void execute() {
		wristSubsystem.goToPosition(wantedAngle);
	}

	@Override
	public boolean isFinished() {
		return wristSubsystem.isAtPosition(wantedAngle);
	}

	@Override
	public void end(boolean interrupted) {
		wristSubsystem.stayInPlace();
	}

}
