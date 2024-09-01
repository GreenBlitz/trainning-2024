package subsystems.elbow;

import edu.wpi.first.math.geometry.Rotation2d;

public interface IElbow {

	public void setPower(double power);

	public void goToPosition(Rotation2d position);

	public void updateInputs(ElbowInputsAutoLogged inputs);

}
