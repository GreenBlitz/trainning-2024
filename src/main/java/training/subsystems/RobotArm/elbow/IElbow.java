package training.subsystems.RobotArm.elbow;

import edu.wpi.first.math.geometry.Rotation2d;

public interface IElbow {

	Rotation2d getPosition();

	Rotation2d getVelocity();

	boolean isAtPosition(Rotation2d position);

	void goToAngle(Rotation2d position);

	void stayInPlace();

	void updateInputs(ElbowInputsAutoLogged inputs);

}
