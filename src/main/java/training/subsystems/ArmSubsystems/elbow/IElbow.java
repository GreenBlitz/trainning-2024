package training.subsystems.ArmSubsystems.elbow;

import edu.wpi.first.math.geometry.Rotation2d;

public interface IElbow {

	void goToPosition(Rotation2d targetPosition);

	void setVoltage(double voltage);

	void setPower(double power);

	void updateInputs(ElbowInputsAutoLogged inputs);


	void setPosition(Rotation2d position);

}
