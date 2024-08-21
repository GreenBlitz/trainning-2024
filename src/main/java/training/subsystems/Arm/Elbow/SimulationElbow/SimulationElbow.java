package training.subsystems.Arm.Elbow.SimulationElbow;

import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.controls.VoltageOut;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.simulation.SingleJointedArmSim;
import training.subsystems.Arm.Elbow.ElbowConstants;
import training.subsystems.Arm.Elbow.ElbowInputsAutoLogged;
import training.subsystems.Arm.Elbow.IElbow;
import utils.simulation.SingleJointedArmSimulation;

public class SimulationElbow implements IElbow {

	private final SingleJointedArmSimulation elbowSimulation;
	private PositionVoltage positionVoltage;
	private VoltageOut voltageOut = new VoltageOut(0);

	public SimulationElbow() {
		SingleJointedArmSim armSimulation = new SingleJointedArmSim(
			DCMotor.getFalcon500(SimulationElbowConstants.NUMBER_OF_MOTORS),
			SimulationElbowConstants.GEAR_RATIO,
			SingleJointedArmSim.estimateMOI(ElbowConstants.ARM_LENGTH, ElbowConstants.ARM_MASS_KG),
			ElbowConstants.ARM_LENGTH,
			ElbowConstants.BACKWARD_ANGLE_LIMIT.getRadians(),
			ElbowConstants.FORWARD_ANGLE_LIMIT.getRadians(),
			false,
			ElbowConstants.PresetPositions.STARTING.angle.getRadians()
		);
		this.elbowSimulation = new SingleJointedArmSimulation(armSimulation);
		elbowSimulation.applyConfiguration(SimulationElbowConstants.CONFIG);
	}


	@Override
	public void setPower(double power) {
		elbowSimulation.setPower(power);
	}

	@Override
	public void setVoltage(double voltage) {
		elbowSimulation.setControl(voltageOut.withOutput(voltage));
	}

	@Override
	public void moveToPosition(Rotation2d targetPosition) {
		elbowSimulation.setControl(positionVoltage.withPosition(targetPosition.getRotations()));
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
