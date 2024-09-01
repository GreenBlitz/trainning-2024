package subsystems.elbow.neoElbow;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.math.geometry.Rotation2d;
import subsystems.elbow.ElbowInputsAutoLogged;
import subsystems.elbow.IElbow;

public class NeoElbow implements IElbow {

	private static CANSparkMax motor;

	public NeoElbow() {
		motor = new CANSparkMax(NeoElbowConstants.MOTOR_ID, CANSparkLowLevel.MotorType.kBrushless);
		motor.getPIDController().setP(NeoElbowConstants.KP);
		motor.getPIDController().setI(NeoElbowConstants.KI);
		motor.getPIDController().setD(NeoElbowConstants.KD);
	}

	public Rotation2d getAngle() {
		return Rotation2d.fromRotations(motor.getEncoder().getPosition() % 1);
	}

	public Rotation2d getVelocity() {
		return Rotation2d.fromRotations(motor.getEncoder().getVelocity());
	}

	@Override
	public void updateInputs(ElbowInputsAutoLogged inputs) {
		inputs.velocity = Rotation2d.fromRotations(motor.getEncoder().getVelocity());
		inputs.angle = Rotation2d.fromRotations(motor.getEncoder().getPosition() % 1);
	}

	@Override
	public void setPower(double power) {
		motor.set(power);
	}

	private double calculateFeedForward() {
		return NeoElbowConstants.FEED_FORWARD.calculate(getAngle().getRadians(), getVelocity().getRotations());
	}

	public void goToPosition(Rotation2d position) {
		motor.getPIDController()
			.setReference(
				position.getRadians(),
				CANSparkBase.ControlType.kPosition,
				NeoElbowConstants.PID_SLOT,
				calculateFeedForward()
			);
	}

}
