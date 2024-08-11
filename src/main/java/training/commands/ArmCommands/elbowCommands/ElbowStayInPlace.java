package training.commands.ArmCommands.elbowCommands;

import edu.wpi.first.wpilibj2.command.Command;
import training.subsystems.ArmSubsystems.elbow.Elbow;
import training.subsystems.ArmSubsystems.elbow.ElbowConstants;

public class ElbowStayInPlace extends Command {

	private final Elbow elbow;

	public ElbowStayInPlace(Elbow elbow) {
		this.elbow = elbow;
		addRequirements(elbow);
	}


	@Override
	public void execute() {
		if (elbow.isAtTargetPosition(elbow.getTargetPosition(), ElbowConstants.POSITION_TOLERANCE, ElbowConstants.VELOCITY_TOLERANCE)) {
			elbow.stayAtPosition();
		}
	}
}
