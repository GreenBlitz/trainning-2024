package training.subsystems.ArmSubsystems.elbow;

import edu.wpi.first.math.geometry.Rotation2d;
import org.littletonrobotics.junction.AutoLog;

@AutoLog
public class ElbowInputs {

	public Rotation2d position = ElbowConstants.STARTING_POSITION;
	public Rotation2d velocity = Rotation2d.fromRotations(0);
	public double current = 0;
	public double voltage = 0;

}
