package training.subsystems.roller;

import edu.wpi.first.math.geometry.Rotation2d;

public interface IRoller {

	void goToSpeed(double targetSpeed);

	Rotation2d getVelocity();

	void stayAtPosition();

	Rotation2d getPosition();

}
