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
	private PositionVoltage positionVoltage;

	public ElbowSimulation() {
		SingleJointedArmSim armSim = new SingleJointedArmSim(
			DCMotor.getNEO(SimulationElbowConstants.NUMBER_OF_MOTORS),
			SimulationElbowConstants.GEAR_RATIO,
			SingleJointedArmSim.estimateMOI(ElbowConstants.ARM_LENGTH, ElbowConstants.ARM_MASS_KG),
			ElbowConstants.ARM_LENGTH,
			ElbowConstants.BACKWARD_ANGLE_LIMIT.getRadians(),
			ElbowConstants.FORWARD_ANGLE_LIMIT.getRadians(),
			false,
			ElbowConstants.PresetPositions.STARTING.ANGLE.getRadians()
		);
		elbowSimulation = new SingleJointedArmSimulation(armSim);
		TalonFXConfiguration config = new TalonFXConfiguration();
		config.Slot0.kP = ElbowConstants.P;
		config.Slot0.kI = ElbowConstants.I;
		config.Slot0.kD = ElbowConstants.D;
		elbowSimulation.applyConfiguration(config);
	}

	public void goToAngle(Rotation2d targetAngle) {
		elbowSimulation.setControl(positionVoltage.withPosition(targetAngle.getRotations()));
	}

	public Rotation2d getPosition() {
		return elbowSimulation.getPosition();
	}

	public Rotation2d getVelocity() {
		return elbowSimulation.getVelocity();
	}

	public void stayAtPosition() {
		goToAngle(getPosition());
	}

}