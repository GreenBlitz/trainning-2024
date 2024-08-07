package training.Roller;

import edu.wpi.first.math.geometry.Rotation2d;

public interface IRoller {

	void setPower(double power);

	Rotation2d getPosition();

	Rotation2d getVelocity();

	void updateVelocity(Rotation2d targetVelocity);

}

