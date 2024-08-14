package training.subsystems.ArmSubsystems.wrist;

import edu.wpi.first.math.geometry.Rotation2d;
import org.littletonrobotics.junction.AutoLog;

@AutoLog
public class WristInputs {

	public Rotation2d position = WristConstants.STARTING_POSITION;
	public double voltage = 0;
	public Rotation2d velocity = Rotation2d.fromRotations(0);

}
