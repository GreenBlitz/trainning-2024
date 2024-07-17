package training.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import utils.GBSubsystem;

public class Module extends GBSubsystem {
	private TalonFX linearMotor;
	private TalonFX angularMotor;
	@Override
	protected String getLogPath() {
		return "";
	}
	
	@Override
	protected void subsystemPeriodic() {
	
	}
	public Module(){
		this.linearMotor = new TalonFX(0);
		this.angularMotor = new TalonFX(1);
	}
	public void moveLinearMotor(double power){
		linearMotor.set(power);
	}
	public void moveAngularMotor(double power){
		angularMotor.set(power);
	}
	public void stopAngularMotor(){
		angularMotor.set(0);
	}
	public void stopLinearMotor(){
		linearMotor.set(0);
	}
	public void stopBouthMotor(){
		linearMotor.set(0);
		angularMotor.set(0);
	}
	
}
