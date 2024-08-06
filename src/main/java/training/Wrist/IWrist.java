package training.Wrist;

import edu.wpi.first.math.geometry.Rotation2d;

public interface IWrist {

	public abstract void setPower(double power);

	public abstract void updateAngle(Rotation2d targetAngle);


}
