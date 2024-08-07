package training.subsystems.Arm.Elbow;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.math.geometry.Rotation2d;

public class NeoElbow implements IElbow {

	private final CANSparkMax motor;

	public NeoElbow() {
		this.motor = new CANSparkMax(NeoElbowConstants.MOTOR_ID, CANSparkLowLevel.MotorType.kBrushless);
		motor.getEncoder().setPositionConversionFactor(NeoElbowConstants.ELBOW_GEAR_RATIO);
		motor.getPIDController().setP(NeoElbowConstants.P);
		motor.getPIDController().setI(NeoElbowConstants.I);
		motor.getPIDController().setD(NeoElbowConstants.D);
		motor.getEncoder().setPosition(NeoElbowConstants.PresetPositions.STARTING.ANGLE.getDegrees());
	}



	@Override
	public void moveToPosition(Rotation2d position) {
		motor.getPIDController()
			.setReference(
				position.getDegrees(),
				CANSparkBase.ControlType.kPosition,
				NeoElbowConstants.PID_SLOT,
				NeoElbowConstants.ARM_FEEDFORWARD.calculate(getPosition().getRadians(), getVelocity().getRotations())
			);
	}

	@Override
	public void stayAtPosition() {
		moveToPosition(getPosition());
	}

	@Override
	public Rotation2d getPosition() {
		return Rotation2d.fromRotations(motor.getEncoder().getPosition());
	}


	public Rotation2d getVelocity() {
		return Rotation2d.fromRotations(motor.getEncoder().getVelocity());
	}

	@Override
	public void setPower(double power) {
		motor.set(power);
	}

}
