package training.subsystems.RobotArm.roller;

import edu.wpi.first.math.geometry.Rotation2d;
import training.subsystems.RobotArm.elbow.ElbowInputsAutoLogged;

public interface IRoller {

	Rotation2d getPosition();

	Rotation2d getVelocity();

	void moveAtSpeed(double velocity);

	void updateInputs(RollerInputsAutoLogged inputs);
}
