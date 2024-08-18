package training.subsystems.ArmSubsystems.roller;

import edu.wpi.first.math.geometry.Rotation2d;
import org.littletonrobotics.junction.AutoLog;

@AutoLog
public class RollerInputs {

	public Rotation2d position=Rotation2d.fromRotations(0);
	public Rotation2d velocity = Rotation2d.fromRotations(0);

}
