package training.commands.ArmCommands.wristCommands;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import training.subsystems.ArmSubsystems.wristSubsystem.Wrist;

public class qiulWrist extends Command {
	
	private final Wrist wrist;
	private final Rotation2d targetPosition;
	
	public qiulWrist(Rotation2d targetPosition) {
		this.wrist = Wrist.getInstance();
		this.targetPosition = targetPosition;
	}
	
	@Override
	public void execute() {
		wrist.goToPosition(targetPosition);
	}
	
}
