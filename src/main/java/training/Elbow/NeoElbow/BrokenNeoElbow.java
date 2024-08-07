package training.Elbow.NeoElbow;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.math.geometry.Rotation2d;
import training.Elbow.IElbow;


public class BrokenNeoElbow implements IElbow {

	private final CANSparkMax motor;

	public BrokenNeoElbow() {
		this.motor = new CANSparkMax(NeoElbowConstants.ID, NeoElbowConstants.MOTOR_TYPE);

		motor.getEncoder().setPositionConversionFactor(NeoElbowConstants.ELBOW_GEAR_RATIO);
		motor.getPIDController().setP(NeoElbowConstants.PID_CONTROLLER.getP());
		motor.getPIDController().setD(NeoElbowConstants.PID_CONTROLLER.getD());
		motor.getPIDController().setI(NeoElbowConstants.PID_CONTROLLER.getI());
		motor.getPIDController()
			.setOutputRange(-NeoElbowConstants.LOWER_POWER_LIMIT, NeoElbowConstants.UPPER_POWER_LIMIT);
		motor.getPIDController().setPositionPIDWrappingMaxInput(1);
		motor.getPIDController().setPositionPIDWrappingMinInput(0);
		motor.getPIDController().getPositionPIDWrappingEnabled();
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
	public void moveToAngle(Rotation2d targetAngle) {
		double targetAngleRotations = targetAngle.getRotations() % 1;
		double feedForwardOutputVoltage = NeoElbowConstants.NEO_FEEDFORWARD
			.calculate(getCurrentAngle().getRadians(), motor.getEncoder().getVelocity());

		motor.getPIDController()
			.setReference(
				targetAngleRotations,
				CANSparkBase.ControlType.kPosition,
				NeoElbowConstants.POSITION_PID_SLOT,
				feedForwardOutputVoltage
			);
	}

}
