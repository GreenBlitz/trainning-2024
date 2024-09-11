package subsystems.wrist;

import edu.wpi.first.math.geometry.Rotation2d;

public interface IWrist {

	public void updateInputs(WristInputsAutoLogged inputs);

	public void goToPosition(Rotation2d position);

	public void setPower(double power);

}
