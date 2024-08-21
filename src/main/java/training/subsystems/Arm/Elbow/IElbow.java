package training.subsystems.Arm.Elbow;

import edu.wpi.first.math.geometry.Rotation2d;

public interface IElbow {

	void setPower(double power);

	void moveToPosition(Rotation2d position);

	Rotation2d getPosition();

	void updateInputs(ElbowInputsAutoLogged inputs);

	void setVoltage(double voltage);
}
