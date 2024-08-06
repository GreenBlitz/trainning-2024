package training.Elbow.NeoElbow;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.math.geometry.Rotation2d;
import training.Elbow.IElbow;


public class BrokenNeoElbow implements IElbow {

	private final CANSparkMax motor;
	private final Rotation2d flooredStartRotations;

	public BrokenNeoElbow() {
		this.motor = new CANSparkMax(NeoElbowConstants.ELBOW_ID, NeoElbowConstants.ELBOW_MOTOR_TYPE);
		this.flooredStartRotations = Rotation2d.fromRotations(Math.floor(motor.getEncoder().getPosition()));

		motor.getEncoder().setPositionConversionFactor(NeoElbowConstants.ELBOW_GEAR_RATIO);
		motor.getPIDController().setP(NeoElbowConstants.ELBOW_PID_CONTROLLER.getP());
		motor.getPIDController().setD(NeoElbowConstants.ELBOW_PID_CONTROLLER.getD());
		motor.getPIDController().setI(NeoElbowConstants.ELBOW_PID_CONTROLLER.getI());
		motor.getPIDController()
			.setOutputRange(-NeoElbowConstants.LOWER_POWER_LIMIT_ELBOW, NeoElbowConstants.UPPER_POWER_LIMIT_ELBOW);
		motor.burnFlash();
	}

	@Override
	public Rotation2d getCurrentAngle() {
		return Rotation2d.fromRotations(motor.getEncoder().getPosition());
	}

	public Rotation2d getCurrentVelocity() {
		return Rotation2d.fromRotations(motor.getEncoder().getVelocity());
	}

	@Override
	public void updateAngle(Rotation2d targetAngle) {
		double target = flooredStartRotations.getRotations() + (targetAngle.getRotations() % 1);
		double FFValue = NeoElbowConstants.NEO_ELBOW_FEEDFORWARD
			.calculate(getCurrentAngle().getRadians(), motor.getEncoder().getVelocity());

		motor.getPIDController().setReference(target, CANSparkBase.ControlType.kPosition, NeoElbowConstants.PID_SLOT, FFValue);
	}

}
