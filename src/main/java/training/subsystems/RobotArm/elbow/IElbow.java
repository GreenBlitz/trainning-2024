package training.subsystems.RobotArm.elbow;

import edu.wpi.first.math.geometry.Rotation2d;

public interface IElbow {

	Rotation2d getPosition();

	void goToAngle(Rotation2d position);

	void stayInPlace();

	void updateInputs(ElbowInputsAutoLogged inputs);

}
