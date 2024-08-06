package training.commands.ArmCommands.wristCommands;

import edu.wpi.first.wpilibj2.command.Command;
import training.subsystems.ArmSubsystems.wristSubsystem.Wrist;

public class WristDefultCommand extends Command {

	private Wrist wrist;

	public WristDefultCommand() {
		this.wrist = Wrist.getInstance();
		addRequirements(wrist);
	}

	public void initialize() {
		wrist.stopMotor();
	}

}
