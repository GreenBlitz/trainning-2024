package training.subsystems.arm.elbow;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.math.geometry.Rotation2d;

public class NEOElbow implements IElbow {

	private final CANSparkMax motor;


	public NEOElbow() {
		this.motor = new CANSparkMax(Constants.MOTOR_ID, CANSparkLowLevel.MotorType.kBrushless);
		motor.getEncoder().setPositionConversionFactor(Constants.GEAR_RATIO);
		motor.getPIDController().setP(Constants.KP);
		motor.getPIDController().setI(Constants.KI);
		motor.getPIDController().setD(Constants.KD);
	}

	public Rotation2d getCurrentAngle() {
		return Rotation2d.fromRotations(motor.getEncoder().getPosition());
	}

	public void setPower(double power) {
		motor.set(power);
	}


	public Rotation2d getCurrentVelocity() {
		return Rotation2d.fromRotations(motor.getEncoder().getVelocity());
	}

	public void moveToAngle(Rotation2d angle) {
		motor.getPIDController()
			.setReference(
				angle.getRotations(),
				CANSparkBase.ControlType.kPosition,
				0,
				Constants.ELBOW_FEEDFORWARD.calculate(getCurrentAngle().getRotations(), getCurrentVelocity().getRotations())
			);
	}

	public void stayInPlace() {
		moveToAngle(Rotation2d.fromRotations(getCurrentAngle().getRotations()));
	}

}
