package training.commands.ArmCommands.wristCommands;

import edu.wpi.first.wpilibj2.command.Command;
import training.subsystems.ArmSubsystems.wristSubsystem.Wrist;

public class WristDefaultCommand extends Command {

	private final Wrist wrist;

	public WristDefaultCommand(Wrist wrist) {
		this.wrist = wrist;
		addRequirements(wrist);
	}

	public void initialize() {
		wrist.stopMotor();
	}

}

