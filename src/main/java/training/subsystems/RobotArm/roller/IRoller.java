package training.subsystems.RobotArm.roller;

import edu.wpi.first.math.geometry.Rotation2d;

public interface IRoller {

	void moveAtSpeed(double velocity);

	void updateInputs(RollerInputsAutoLogged inputs);

}
