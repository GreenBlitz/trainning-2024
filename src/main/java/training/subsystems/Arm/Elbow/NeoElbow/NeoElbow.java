package training.subsystems.Arm.Elbow.NeoElbow;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkBase.ControlType;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.math.geometry.Rotation2d;
import training.subsystems.Arm.Elbow.ElbowConstants;
import training.subsystems.Arm.Elbow.ElbowInputsAutoLogged;
import training.subsystems.Arm.Elbow.IElbow;

public class NeoElbow implements IElbow {

	private final CANSparkMax motor;
	private final ControlType controlType = CANSparkBase.ControlType.kPosition;
	private final int pidSlot = NeoElbowConstants.PID_SLOT;
	private final double feedForward_Calculation = NeoElbowConstants.FEEDFORWARD
			.calculate(
					getPosition().getRadians(),
					getVelocity().getRotations()
			);

	public NeoElbow() {
		this.motor = new CANSparkMax(NeoElbowConstants.ID, CANSparkLowLevel.MotorType.kBrushless);
		motor.getEncoder().setPositionConversionFactor(NeoElbowConstants.GEAR_RATIO);
		motor.getEncoder().setVelocityConversionFactor(NeoElbowConstants.GEAR_RATIO);
		motor.getPIDController().setP(NeoElbowConstants.P);
		motor.getPIDController().setI(NeoElbowConstants.I);
		motor.getPIDController().setD(NeoElbowConstants.D);
		motor.getEncoder().setPosition(ElbowConstants.PresetPositions.STARTING.angle.getRotations());
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

	@Override
	public void moveToPosition(Rotation2d position) {
		motor.getPIDController()
				.setReference(
						position.getRotations(),
						controlType,
						pidSlot,
						feedForward_Calculation
				);
	}

	@Override
	public void updateInputs(ElbowInputsAutoLogged inputs) {
		inputs.velocity = this.getVelocity().getRotations();
		inputs.current = this.motor.getOutputCurrent();
		inputs.position = this.getPosition();
		inputs.voltage = motor.getBusVoltage() * motor.getAppliedOutput();
	}

}
