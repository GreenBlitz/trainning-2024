package training.subsystems.module;

import com.ctre.phoenix6.configs.FeedbackConfigs;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import utils.GBSubsystem;

public class Module extends GBSubsystem {
	
	public final TalonFX steer;
	private final TalonFX linear;
	
	public Module() {
		this.steer = new TalonFX(ModuleConstants.STEER_ID);
		steer.getConfigurator().apply(new FeedbackConfigs().withSensorToMechanismRatio(150 / 7.0));
		this.linear = new TalonFX(ModuleConstants.LINEAR_ID);
	}
	
	public void moveAngle(Rotation2d angle, double power) {
		Rotation2d currentAngle = Rotation2d.fromRotations(steer.getPosition().getValue());
		currentAngle = Rotation2d.fromDegrees(currentAngle.getDegrees() % 360);
		
		double delta = angle.getDegrees() - Math.abs(currentAngle.getDegrees());
		
		SmartDashboard.putNumber("WHat the sigmaaa", delta);
		
		if(delta > 0 && delta < 10){
			setPower(0);
		}
		else {
			if (delta <= 180 && delta > -1) {
				setPower(power);
			}
			if (delta < 0 && delta >= -180) {
				setPower(-power);
			}
			if (delta > 180) {
				setPower(-power);
			} else {
				setPower(power);
			}
		}
	}

		
		@Override
		protected String getLogPath () {
			return "sog,a";
		}
		
		@Override
		protected void subsystemPeriodic () {
		
		}
		
		public void setPower ( double power){
			steer.set(power);
		}
		
		public void stopSteer () {
			setPower(0);
		}
		
		public boolean isItAngle (Rotation2d angle){
			Rotation2d currentAngle = Rotation2d.fromRotations(steer.getPosition().getValue());
			currentAngle = Rotation2d.fromDegrees(currentAngle.getDegrees() % 360);
			angle.plus(Rotation2d.fromDegrees(180));
			
			return Math.abs(currentAngle.getDegrees() - angle.getDegrees()) < 10;
		}
	}

