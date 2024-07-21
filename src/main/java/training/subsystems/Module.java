package training.subsystems;

import com.ctre.phoenix6.configs.FeedbackConfigs;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import training.ModuleConstants;
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
		angularMotor.setPosition(0);
		angularMotor.getConfigurator().apply(new FeedbackConfigs().withSensorToMechanismRatio(150/7));
		angularMotor.getConfigurator().apply(ModuleConstants.ASS);
		
		
	}
	public void setAngularMotorByPosition(double position){
		angularMotor.setControl(new PositionVoltage(position));
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
	public void stopBothMotor(){
		linearMotor.set(0);
		angularMotor.set(0);
	}
	public double getAngularPosition() {
		return angularMotor.getPosition().getValue();
	}
}
