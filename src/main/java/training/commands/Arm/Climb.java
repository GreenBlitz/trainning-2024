package training.commands.Arm;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import training.subsystems.Arm.ElbowSubsystem;
import training.subsystems.Arm.RollerSubsystem;
import training.subsystems.Arm.WristSubsystem;

public class Climb extends Command {
	private ElbowSubsystem elbow;
	private RollerSubsystem roller;
	private WristSubsystem wrist;
	private MoveElbow moveElbow;
	private MoveWrist moveWrist;
	private rollerBackwards rollerBackwards;
	private rollerForward rollerForward;
	
	public Climb(ElbowSubsystem elbow, RollerSubsystem roller, WristSubsystem wrist){
		this.elbow = elbow;
		this.roller = roller;
		this.wrist = wrist;
		this.moveElbow = new MoveElbow(this.elbow, Constants.ELBOW_CLIMBING_POSITION);
		this.moveWrist = new MoveWrist(this.wrist, Constants.WRIST_CLIMBING_POSITION);
		this.rollerForward = new rollerForward(this.roller);
	}
	
	@Override
	public void initialize() {
	
	}
}
