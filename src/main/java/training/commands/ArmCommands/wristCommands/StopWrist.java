package training.commands.ArmCommands.wristCommands;

import edu.wpi.first.wpilibj2.command.Command;
import training.subsystems.ArmSubsystems.wrist.Wrist;

public class StopWrist extends Command {

	private final Wrist wrist;

	public StopWrist(Wrist wrist) {
		this.wrist = wrist;
		addRequirements(wrist);

	}

	@Override
	public void initialize() {
		wrist.stopMotor();
	}

}

