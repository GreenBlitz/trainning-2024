package training.subsystems.Arm.Elbow;

import edu.wpi.first.math.geometry.Rotation2d;

public interface IElbow {

	void setPower(double power);

	void moveToPosition(Rotation2d position);

	void stayAtPosition();

	Rotation2d getPosition();



}
