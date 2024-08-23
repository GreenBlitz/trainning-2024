package training.subsystems.wrist;

import edu.wpi.first.math.geometry.Rotation2d;

public interface IWrist {

	void goToAngle(Rotation2d targetAngle);

	void stop();

}
