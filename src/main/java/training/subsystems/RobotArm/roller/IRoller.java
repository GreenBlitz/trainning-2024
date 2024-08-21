package training.subsystems.RobotArm.roller;

import edu.wpi.first.math.geometry.Rotation2d;

public interface IRoller {

	Rotation2d getPosition();

	Rotation2d getVelocity();

	void moveAtSpeed(double velocity);

	boolean isAtSpeed(Rotation2d velocity);

}
