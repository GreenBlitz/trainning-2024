package training.Elbow.NeoElbow;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.geometry.Rotation2d;
import training.Elbow.ElbowInputsAutoLogged;
import training.Elbow.IElbow;


public class NeoElbow implements IElbow {

	private final CANSparkMax motor;
	private double pidOutput;
	private ArmFeedforward feedforwardController;

	public NeoElbow() {
		this.motor = new CANSparkMax(NeoElbowConstants.ID, NeoElbowConstants.MOTOR_TYPE);
		this.feedforwardController = NeoElbowConstants.FEEDFORWARD;

		motor.getEncoder().setPositionConversionFactor(NeoElbowConstants.ELBOW_GEAR_RATIO);
		motor.getPIDController().setP(NeoElbowConstants.PID_CONTROLLER.getP());
		motor.getPIDController().setD(NeoElbowConstants.PID_CONTROLLER.getD());
		motor.getPIDController().setI(NeoElbowConstants.PID_CONTROLLER.getI());
		motor.getPIDController().setOutputRange(NeoElbowConstants.MINIMUM_POWER_LIMIT, NeoElbowConstants.MAXIMUM_POWER_LIMIT);
		motor.getPIDController().setPositionPIDWrappingMaxInput(1);
		motor.getPIDController().setPositionPIDWrappingMinInput(0);
		motor.getPIDController().getPositionPIDWrappingEnabled();
		motor.burnFlash();

		motor.setSoftLimit(CANSparkMax.SoftLimitDirection.kReverse, (float) NeoElbowConstants.BACKWARD_ANGLE_LIMIT.getRadians());
		motor.setSoftLimit(CANSparkMax.SoftLimitDirection.kForward, (float) NeoElbowConstants.FORWARD_ANGLE_LIMIT.getRadians());
	}

	public Rotation2d getCurrentVelocity() {
		return Rotation2d.fromRotations(motor.getEncoder().getVelocity());
	}

	@Override
	public void moveToAngle(Rotation2d targetAngle) {
		double targetAngleRotations = targetAngle.getRotations() % 1;
		double feedForwardOutputVoltage = feedforwardController
			.calculate(motor.getEncoder().getPosition(), motor.getEncoder().getVelocity());

		motor.getPIDController()
			.setReference(
				targetAngleRotations,
				CANSparkBase.ControlType.kPosition,
				NeoElbowConstants.POSITION_PID_SLOT,
				feedForwardOutputVoltage
			);
	}

	@Override
	public void updateInputs(ElbowInputsAutoLogged inputs) {
		inputs.outputCurrent = motor.getOutputCurrent();
		inputs.position = Rotation2d.fromRotations(motor.getEncoder().getPosition());
		inputs.velocity = Rotation2d.fromRadians(motor.getEncoder().getVelocity());
	}

	@Override
	public void updatePID(double kP, double kI, double kD) {
		if (kP == -1) {
			kP = motor.getPIDController().getP();
		}
		if (kI == -1) {
			kI = motor.getPIDController().getI();
		}
		if (kD == -1) {
			kD = motor.getPIDController().getD();
		}

		motor.getPIDController().setP(kP);
		motor.getPIDController().setP(kI);
		motor.getPIDController().setP(kD);
		motor.burnFlash();
	}

	@Override
	public void updateFF(double kS, double kG, double kV, double kA) {
		if (kS == -1) {
			kS = feedforwardController.ks;
		}
		if (kG == -1) {
			kG = feedforwardController.kg;
		}
		if (kV == -1) {
			kV = feedforwardController.kv;
		}
		if (kA == -1) {
			kA = feedforwardController.ka;
		}

		feedforwardController = new ArmFeedforward(kS, kG, kV, kA);
	}

}
