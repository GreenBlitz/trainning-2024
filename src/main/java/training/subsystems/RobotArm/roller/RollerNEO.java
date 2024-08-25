package training.subsystems.RobotArm.roller;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.math.geometry.Rotation2d;

public class RollerNEO implements IRoller {

	private CANSparkMax motor;
	private static RollerNEO instance;

	private RollerNEO() {
		this.motor = new CANSparkMax(RollerConstants.MOTOR_ID, CANSparkLowLevel.MotorType.kBrushless);
		motor.getPIDController().setP(RollerConstants.KP);
		motor.getPIDController().setI(RollerConstants.KI);
		motor.getPIDController().setD(RollerConstants.KD);
	}


	public void moveAtSpeed(double velocity) {
		motor.getPIDController().setReference(velocity, CANSparkBase.ControlType.kVelocity, RollerConstants.PID_SLOT);
	}


	public Rotation2d getPosition() {
		return Rotation2d.fromDegrees(motor.getEncoder().getPosition());
	}

	public Rotation2d getVelocity() {
		return Rotation2d.fromDegrees(motor.getEncoder().getVelocity());
	}

	@Override
	public void updateInputs(RollerInputsAutoLogged inputs) {
		inputs.position = getPosition();
	}

	protected String getLogPath() {
		return "Roller/";
	}

	protected void subsystemPeriodic() {}

}
