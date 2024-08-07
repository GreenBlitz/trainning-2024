package training.commands.ArmCommands.elbowCommands;

import edu.wpi.first.wpilibj2.command.Command;
import training.subsystems.ArmSubsystems.elbow.Elbow;

public class ElbowStayInPlace extends Command {

	private final Elbow elbow;

	public ElbowStayInPlace(Elbow elbow) {
		this.elbow = elbow;
		addRequirements(elbow);
	}

	@Override
	public void initialize() {
		elbow.stayAtPosition();
	}

}
