package training.Roller.NeoRoller;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.math.geometry.Rotation2d;
import training.Roller.IRoller;
import training.Roller.RollerInputsAutoLogged;


public class NeoRoller implements IRoller {

	private final CANSparkMax motor;

	public NeoRoller() {
		this.motor = new CANSparkMax(NeoRollerConstants.ID, NeoRollerConstants.MOTOR_TYPE);

		motor.getEncoder().setPositionConversionFactor(NeoRollerConstants.GEAR_RATIO);
		motor.getPIDController().setP(NeoRollerConstants.KP);
		motor.getPIDController().setI(NeoRollerConstants.KI);
		motor.getPIDController().setD(NeoRollerConstants.KD);
		motor.getPIDController().setOutputRange(NeoRollerConstants.POWER_LIMIT_BELOW, NeoRollerConstants.POWER_LIMIT_ABOVE);
		motor.burnFlash(); // applies some of the changes above
	}

	@Override
	public void updateVelocity(Rotation2d targetVelocity) {
		motor.getPIDController().setReference(targetVelocity.getRotations(), CANSparkBase.ControlType.kVelocity);
	}

	@Override
	public void setPower(double power) {
		motor.set(power);
	}

	@Override
	public void updateInputs(RollerInputsAutoLogged inputs) {
		inputs.outputCurrent = motor.getOutputCurrent();
		inputs.position = Rotation2d.fromRotations(motor.getEncoder().getPosition());
		inputs.velocity = Rotation2d.fromRotations(motor.getEncoder().getVelocity());
	}

}
