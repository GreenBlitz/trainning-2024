package training.subsystems.RobotArm.elbow;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.math.geometry.Rotation2d;

public class ElbowNEO implements IElbow {

	private final CANSparkMax motor;
	private Rotation2d position;

	public ElbowNEO() {
		this.motor = new CANSparkMax(ElbowConstants.MOTOR_ID, CANSparkLowLevel.MotorType.kBrushless);
		this.position = new Rotation2d(ElbowConstants.BEGINNING_POSITION);
		motor.getPIDController().setP(ElbowConstants.KP);
		motor.getPIDController().setI(ElbowConstants.KI);
		motor.getPIDController().setD(ElbowConstants.KD);
	}

	@Override
	public void goToAngle(Rotation2d position) {
		motor.getPIDController()
			.setReference(
				position.getDegrees(),
				CANSparkBase.ControlType.kPosition,
				ElbowConstants.PID_SLOT,
				ElbowConstants.ARM_FEED_FORWARD.calculate(getPosition().getDegrees(), getVelocity().getDegrees())
			);
	}

	public Rotation2d getPosition() {
		return Rotation2d.fromDegrees(motor.getEncoder().getPosition());
	}

	public Rotation2d getVelocity() {
		return Rotation2d.fromDegrees(motor.getEncoder().getVelocity());
	}



	@Override
	public void stayInPlace() {
		goToAngle(position);
	}

	@Override
	public void updateInputs(ElbowInputsAutoLogged inputs) {
		inputs.position = getPosition();
	}

}
