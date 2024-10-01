package training.subsystems.ArmSubsystems.roller.NeoRoller;

import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.math.geometry.Rotation2d;
import training.subsystems.ArmSubsystems.roller.IRoller;
import training.subsystems.ArmSubsystems.roller.RollerInputsAutoLogged;

public class NeoRoller implements IRoller {

	private final CANSparkMax motor;

	public NeoRoller() {
		this.motor = new CANSparkMax(NeoRollerConstants.ID, CANSparkLowLevel.MotorType.kBrushless);
	}

	public void setPower(double power) {
		motor.set(power);
	}

	public void setVoltage(double voltage) {
		motor.setVoltage(voltage);
	}

	public void updateInputs(RollerInputsAutoLogged inputs) {
		inputs.position = Rotation2d.fromRotations(motor.getEncoder().getPosition());
		inputs.velocity = Rotation2d.fromRotations(motor.getEncoder().getVelocity());
	}

}
