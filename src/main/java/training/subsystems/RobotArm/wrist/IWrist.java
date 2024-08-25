package training.subsystems.RobotArm.wrist;

import edu.wpi.first.math.geometry.Rotation2d;

public interface IWrist {

	void goToPosition(Rotation2d velocity);

}
