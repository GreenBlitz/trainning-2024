package training.Roller.NeoRoller;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.math.geometry.Rotation2d;
import training.Roller.IRoller;


public class NeoRoller implements IRoller {

	private final CANSparkMax motor;

	public NeoRoller() {
		this.motor = new CANSparkMax(NeoRollerConstants.ID, NeoRollerConstants.MOTOR_TYPE);

		motor.getEncoder().setPositionConversionFactor(NeoRollerConstants.GEAR_RATIO);
		motor.getPIDController().setP(NeoRollerConstants.KP);
		motor.getPIDController().setI(NeoRollerConstants.KI);
		motor.getPIDController().setD(NeoRollerConstants.KD);
		motor.getPIDController().setOutputRange(-NeoRollerConstants.POWER_LIMIT, NeoRollerConstants.POWER_LIMIT);
		motor.burnFlash(); // applies some of the changes above
	}

	@Override
	public void updateVelocity(Rotation2d targetVelocity) {
		motor.getPIDController().setReference(targetVelocity.getRotations(), CANSparkBase.ControlType.kVelocity);
	}

	@Override
	public Rotation2d getPosition() {
		return new Rotation2d(motor.getEncoder().getPosition());
	}

	@Override
	public Rotation2d getVelocity() {
		return Rotation2d.fromRotations(motor.getEncoder().getVelocity());
	}

	@Override
	public void setPower(double power) {
		motor.set(power);
	}

}
