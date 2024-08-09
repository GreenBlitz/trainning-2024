package training.Roller;

import edu.wpi.first.math.geometry.Rotation2d;

public interface IRoller {

	void setPower(double power);

	void updateVelocity(Rotation2d targetVelocity);

	void updateInputs(RollerInputsAutoLogged inputs);

}
