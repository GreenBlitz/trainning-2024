package training.Elbow;

import edu.wpi.first.math.geometry.Rotation2d;

public interface IElbow {

	void moveToAngle(Rotation2d targetAngle);

	void updateInputs(ElbowInputsAutoLogged inputs);

	void updatePID(double kP, double kI, double kD);

	void updateFF(double kS, double kG, double kV, double kA);

}
