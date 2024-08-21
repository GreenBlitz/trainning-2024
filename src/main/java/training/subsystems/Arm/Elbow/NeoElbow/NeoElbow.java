package training.subsystems.Arm.Elbow.NeoElbow;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkBase.ControlType;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.geometry.Rotation2d;
import training.subsystems.Arm.Elbow.ElbowConstants;
import training.subsystems.Arm.Elbow.ElbowInputsAutoLogged;
import training.subsystems.Arm.Elbow.IElbow;

import static training.subsystems.Arm.Elbow.NeoElbow.NeoElbowConstants.*;

public class NeoElbow implements IElbow {

	private final CANSparkMax motor;
	protected final ArmFeedforward feedforward;
	private final ControlType controlType;
	private final int pidSlot;
	private final double feedForward_Calculation;

	public NeoElbow() {
		this.motor = new CANSparkMax(NeoElbowConstants.ID, CANSparkLowLevel.MotorType.kBrushless);
		feedforward = new ArmFeedforward(KS, KG, KV, KA);
		controlType = CANSparkBase.ControlType.kPosition;
		pidSlot = NeoElbowConstants.PID_SLOT;
		feedForward_Calculation = feedforward.calculate(getPosition().getRadians(), getVelocity().getRotations());
		configMotor();
		motor.burnFlash();
	}

	public void configMotor() {
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
	public void setVoltage(double voltage){
		motor.setVoltage(voltage);
	}

	@Override
	public void moveToPosition(Rotation2d position) {
		motor.getPIDController().setReference(
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
