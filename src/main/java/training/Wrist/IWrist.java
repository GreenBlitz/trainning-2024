package training.Wrist;

import edu.wpi.first.math.geometry.Rotation2d;

public interface IWrist {

	void setPower(double power);

	void updateAngle(Rotation2d targetAngle);


}
