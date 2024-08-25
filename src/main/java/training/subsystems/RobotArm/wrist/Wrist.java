package training.subsystems.RobotArm.wrist;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.math.geometry.Rotation2d;
import utils.GBSubsystem;

public class Wrist extends GBSubsystem {

	private TalonSRX Wrist;
	private Rotation2d position;
	private static Wrist instance;

	public Wrist() {
		this.Wrist = new TalonSRX(WristConstans.MOTOR_ID);
		this.position = new Rotation2d();
		Wrist.configAllSettings(WristConstans.TALON_SRX_CONFIGURATION);
		Wrist.configSelectedFeedbackSensor(
			FeedbackDevice.CTRE_MagEncoder_Relative,
			WristConstans.PID_SLOT,
			WristConstans.TIME_OUT_FOR_CONFIGS_SET
		);
	}

	public Rotation2d getPosition() {
		return Rotation2d.fromDegrees(Wrist.getSelectedSensorPosition());
	}

	public void goToPosition(Rotation2d position) {
		Wrist.selectProfileSlot(WristConstans.PID_SLOT, 0);
		Wrist.set(ControlMode.Position, position.getRotations() * WristConstans.MAG_ENCODER_CONVERSION_FACTOR);
	}

	public boolean isAtPosition(Rotation2d position) {
		return (position == getPosition());
	}

	public void stayInPlace() {
		goToPosition(getPosition());
	}

	@Override
	protected String getLogPath() {
		return "Wrist/";
	}

	@Override
	protected void subsystemPeriodic() {}

}
