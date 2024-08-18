package training.subsystems.elbow;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.PositionVoltage;
import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.simulation.SingleJointedArmSim;
import utils.simulation.SingleJointedArmSimulation;

public class ElbowSimulation implements IElbow {

	private SingleJointedArmSimulation elbowSimulation;
	private ArmFeedforward armFeedforward;
	private PIDController controller;

	private ElbowSimulation() {
		SingleJointedArmSim armSim = new SingleJointedArmSim(
			DCMotor.getFalcon500(SimulationElbowConstants.NUMBER_OF_MOTORS),
			SimulationElbowConstants.GEAR_RATIO,
			SingleJointedArmSim.estimateMOI(ElbowConstants.ARM_LENGTH, ElbowConstants.ARM_MASS_KG),
			ElbowConstants.ARM_LENGTH,
			ElbowConstants.BACKWARD_ANGLE_LIMIT.getRadians(),
			ElbowConstants.FORWARD_ANGLE_LIMIT.getRadians(),
			false,
			ElbowConstants.PresetPositions.STARTING.ANGLE.getRadians()
		);
		elbowSimulation = new SingleJointedArmSimulation(armSim);
		controller = new PIDController(SimulationElbowConstants.P, SimulationElbowConstants.I, SimulationElbowConstants.D);
		TalonFXConfiguration config = new TalonFXConfiguration();
		config.Slot0.kP = controller.getP();
		config.Slot0.kI = controller.getI();
		config.Slot0.kD = controller.getD();
		elbowSimulation.applyConfiguration(config);
	}

	public Rotation2d getPosition() {
		return elbowSimulation.getPosition();
	}

	public Rotation2d getVelocity() {
		return elbowSimulation.getVelocity();
	}


	public void goToAngle(Rotation2d targetAngle) {
		PositionVoltage pos = new PositionVoltage(targetAngle.getRotations());
		elbowSimulation.setControl(pos);
	}

	public void stop() {
		goToAngle(getPosition());
	}

}
