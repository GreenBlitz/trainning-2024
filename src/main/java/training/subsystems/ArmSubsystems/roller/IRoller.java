package training.subsystems.ArmSubsystems.roller;


public interface IRoller {

	public void setPower(double power);

	public void setVoltage(double voltage);

	public void updateInputs(RollerInputsAutoLogged inputs);

}
