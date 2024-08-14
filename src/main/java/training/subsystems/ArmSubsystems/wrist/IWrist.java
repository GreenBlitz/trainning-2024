package training.subsystems.ArmSubsystems.wrist;

import edu.wpi.first.math.geometry.Rotation2d;

public interface IWrist {

	public void goToPosition(Rotation2d targetPosition);

	public void setPower(double power);

	public void setVoltage(double voltage);

	public void updateInputs(WristInputsAutoLogged inputs);


}
