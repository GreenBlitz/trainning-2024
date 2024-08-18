package training.commands.ArmCommands.elbowCommands;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import training.subsystems.ArmSubsystems.elbow.Elbow;


public class ElbowStayInPlace extends Command {

	private Elbow elbow;

	public ElbowStayInPlace(Elbow elbow) {
		this.elbow = elbow;
		addRequirements(elbow);
	}

	@Override
	public void execute() {
		elbow.stayAtPosition();
	}

}
