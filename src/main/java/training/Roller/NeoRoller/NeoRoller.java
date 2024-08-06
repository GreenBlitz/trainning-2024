package training.Roller.NeoRoller;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.math.geometry.Rotation2d;
import training.Roller.IRoller;
import training.Roller.RollerDirection;


public class NeoRoller implements IRoller {

	private final CANSparkMax motor;

	public NeoRoller() {
		this.motor = new CANSparkMax(NeoRollerConstants.ROLLER_ID, NeoRollerConstants.ROLLER_MOTOR_TYPE);

		motor.getEncoder().setPositionConversionFactor(NeoRollerConstants.ROLLER_GEAR_RATIO);
		motor.getPIDController().setP(NeoRollerConstants.ROLLER_P);
		motor.getPIDController().setI(NeoRollerConstants.ROLLER_I);
		motor.getPIDController().setD(NeoRollerConstants.ROLLER_D);
		motor.getPIDController().setOutputRange(-NeoRollerConstants.POWER_LIMIT_ROLLER, NeoRollerConstants.POWER_LIMIT_ROLLER);
		motor.burnFlash(); // applies some of the changes above
	}

	@Override
	public void updateVelocity(Rotation2d targetVelocity, RollerDirection direction) {
		motor.getPIDController()
			.setReference(targetVelocity.getRotations() * direction.toInt(), CANSparkBase.ControlType.kVelocity);
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
