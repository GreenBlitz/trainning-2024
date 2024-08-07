package training.subsystems.Arm.Elbow.SimulationElbow;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.ControlRequest;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.controls.VoltageOut;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.simulation.SingleJointedArmSim;
import org.littletonrobotics.junction.Logger;
import training.subsystems.Arm.Elbow.ElbowConstants;
import training.subsystems.Arm.Elbow.ElbowInputsAutoLogged;
import training.subsystems.Arm.Elbow.IElbow;
import utils.simulation.SingleJointedArmSimulation;

public class SimulationElbow implements IElbow {

	private final SingleJointedArmSimulation elbowSimulation;
	private final PIDController controller;
	private final TalonFXConfiguration config;
	private PositionVoltage positionVoltage = new PositionVoltage(ElbowConstants.PresetPositions.STARTING.ANGLE.getRotations());


	public SimulationElbow() {
		final SingleJointedArmSim armSimulation = new SingleJointedArmSim(
			DCMotor.getFalcon500(SimulationElbowConstants.NUMBER_OF_MOTORS),
			SimulationElbowConstants.GEAR_RATIO,
			SingleJointedArmSim.estimateMOI(SimulationElbowConstants.ARM_LENGTH, SimulationElbowConstants.ARM_MASS_KG),
			SimulationElbowConstants.ARM_LENGTH,
			SimulationElbowConstants.BACKWARD_ANGLE_LIMIT.getRadians(),
			SimulationElbowConstants.FORWARD_ANGLE_LIMIT.getRadians(),
			false,
			ElbowConstants.PresetPositions.STARTING.ANGLE.getRadians()
		);
		this.controller = new PIDController(SimulationElbowConstants.P, SimulationElbowConstants.I, SimulationElbowConstants.D);
		this.elbowSimulation = new SingleJointedArmSimulation(armSimulation);
		this.config = new TalonFXConfiguration();
		config.Slot0.kP = controller.getP();
		config.Slot0.kI = controller.getI();
		config.Slot0.kD = controller.getD();
		elbowSimulation.applyConfiguration(config);
	}


	@Override
	public void setPower(double power) {
		elbowSimulation.setPower(power);
		Logger.recordOutput(SimulationElbowConstants.notMagic, "Power is now" + elbowSimulation.getCurrent());
	}

	public void setVoltage(double voltage){
		VoltageOut voltageOut = new VoltageOut(voltage);
		elbowSimulation.setControl(voltageOut);
		Logger.recordOutput(SimulationElbowConstants.notMagic, "Voltage is not" + elbowSimulation.getVoltage());
	}

	@Override
	public void moveToPosition(Rotation2d targetPosition) {
		elbowSimulation.setControl(positionVoltage.withPosition(targetPosition.getRotations()));
		Logger.recordOutput(SimulationElbowConstants.notMagic, "Moved to" + getPosition());
	}

	@Override
	public void stayAtPosition() {
		moveToPosition(getPosition());
		Logger.recordOutput(SimulationElbowConstants.notMagic, "At position" + getPosition());
	}

	@Override
	public Rotation2d getPosition() {
		return elbowSimulation.getPosition();
	}

	@Override
	public void updateInputs(ElbowInputsAutoLogged inputs) {
		inputs.current = elbowSimulation.getCurrent();
		inputs.position = elbowSimulation.getPosition();
		inputs.velocity = elbowSimulation.getVelocity().getRotations();
		inputs.voltage = elbowSimulation.getVoltage();
	}

}
