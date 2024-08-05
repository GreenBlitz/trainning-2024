package training.subsystems.Arm.Elbow;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.math.geometry.Rotation2d;

public class NeoElbow implements IElbow {

	private final CANSparkMax motor;
	private static NeoElbow instance;

	public NeoElbow() {
		this.motor = new CANSparkMax(ElbowConstants.MOTOR_ID, CANSparkLowLevel.MotorType.kBrushless);
		motor.getEncoder().setPositionConversionFactor(ElbowConstants.ELBOW_GEAR_RATIO);
		motor.getPIDController().setP(ElbowConstants.P);
		motor.getPIDController().setI(ElbowConstants.I);
		motor.getPIDController().setD(ElbowConstants.D);
		motor.getEncoder().setPosition(ElbowConstants.ELBOW_START_POSITION.getDegrees());
	}

	public static NeoElbow getInstance() {
		if (instance == null) {
			instance = new NeoElbow();
		}
		return instance;
	}

	@Override
	public void moveToPosition(Rotation2d position) {
		motor.getPIDController()
			.setReference(
				position.getDegrees(),
				CANSparkBase.ControlType.kPosition,
				ElbowConstants.PID_SLOT,
				ElbowConstants.ARM_FEEDFORWARD.calculate(getPosition().getRadians(), getVelocity().getRotations())
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


	public boolean isAtPosition(Rotation2d target) {
		return Math.abs(getPosition().getDegrees() - target.getDegrees()) <= ElbowConstants.TOLERANCE;
	}

}
