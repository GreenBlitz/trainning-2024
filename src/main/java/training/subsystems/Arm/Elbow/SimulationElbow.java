package training.subsystems.Arm.Elbow;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.PositionVoltage;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.simulation.SingleJointedArmSim;
import utils.simulation.SingleJointedArmSimulation;

public class SimulationElbow implements IElbow {

	private final SingleJointedArmSimulation elbowSimulation;
	private final PIDController controller;
	private final TalonFXConfiguration config;


	public SimulationElbow() {
		final SingleJointedArmSim armSimulation = new SingleJointedArmSim(
			DCMotor.getFalcon500(SimulationElbowConstants.NUMBER_OF_MOTORS),
			SimulationElbowConstants.GEAR_RATIO,
			SingleJointedArmSim.estimateMOI(SimulationElbowConstants.ARM_LENGTH, SimulationElbowConstants.ARM_MASS_KG),
			SimulationElbowConstants.ARM_LENGTH,
			SimulationElbowConstants.BACKWARD_ANGLE_LIMIT.getRadians(),
			SimulationElbowConstants.FORWARD_ANGLE_LIMIT.getRadians(),
			false,
			SimulationElbowConstants.PresetPositions.STARTING.ANGLE.getRadians()
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
	}

	@Override
	public void moveToPosition(Rotation2d targetPosition) {
		elbowSimulation.setControl(new PositionVoltage(targetPosition.getRotations()));
	}

	@Override
	public void stayAtPosition() {
		moveToPosition(getPosition());
	}

	@Override
	public Rotation2d getPosition() {
		return elbowSimulation.getPosition();
	}


	public Rotation2d getVelocity() {
		return elbowSimulation.getVelocity();
	}

}
