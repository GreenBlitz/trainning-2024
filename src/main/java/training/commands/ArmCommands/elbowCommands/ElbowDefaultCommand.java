package training.commands.ArmCommands.elbowCommands;

import edu.wpi.first.wpilibj2.command.Command;
import training.subsystems.ArmSubsystems.elbowSubsystem.Elbow;

public class ElbowDefaultCommand extends Command {

	private final Elbow elbow;

	public ElbowDefaultCommand(Elbow elbow) {
		this.elbow = elbow;
		addRequirements(elbow);
	}

	@Override
	public void initialize() {
		elbow.stayAtPosition();
	}


}
