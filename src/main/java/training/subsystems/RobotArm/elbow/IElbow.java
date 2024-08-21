package training.subsystems.RobotArm.elbow;

import edu.wpi.first.math.geometry.Rotation2d;

public interface IElbow {

	Rotation2d getPosition();

	Rotation2d getVelocity();

}
