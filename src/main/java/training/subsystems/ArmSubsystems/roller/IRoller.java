package training.subsystems.ArmSubsystems.roller;

import training.subsystems.ArmSubsystems.elbow.ElbowInputsAutoLogged;

public interface IRoller {

	public void setPower(double power);

	public void setVoltage(double voltage);

	public void updateInputs(RollerInputsAutoLogged inputs);

}
