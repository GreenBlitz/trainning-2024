package training.commands.ArmCommands.elbowCommands;

import edu.wpi.first.wpilibj2.command.Command;
import training.subsystems.ArmSubsystems.elbowSubsystem.Elbow;

public class ElbowDefultCommand extends Command {

	private Elbow elbow;

	public ElbowDefultCommand() {
		this.elbow = Elbow.getInstance();
		addRequirements(elbow);
	}

	@Override
	public void initialize() {
		elbow.stayAtPosition();
	}



}
