package training.commands.ArmCommands.elbowCommands;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import training.subsystems.ArmSubsystems.elbow.Elbow;


public class ElbowStayInPlace extends Command {

	private Elbow elbow;
	private Rotation2d targetPositon;

	public ElbowStayInPlace(Elbow elbow) {
		this.elbow = elbow;
		addRequirements(elbow);
		targetPositon=elbow.getPosition();
	}

	@Override
	public void initialize() {
		super.initialize();
	}

	@Override
	public void execute() {
		elbow.stayInPosition(targetPositon);
	}

}
