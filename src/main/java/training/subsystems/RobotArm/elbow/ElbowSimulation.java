package training.subsystems.RobotArm.elbow;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.PositionVoltage;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.simulation.SingleJointedArmSim;
import utils.simulation.SingleJointedArmSimulation;

public class ElbowSimulation implements IElbow {

	private SingleJointedArmSimulation motor;
	private Rotation2d position;
	private static ElbowSimulation instance;
	private PIDController controller;

	public ElbowSimulation() {
		SingleJointedArmSim armSim = new SingleJointedArmSim(
			DCMotor.getFalcon500(ElbowSimulationConstants.NUMBER_OF_MOTORS),
			ElbowSimulationConstants.GEAR_RATIO,
			SingleJointedArmSim.estimateMOI(ElbowConstants.ARM_LENGTH, ElbowConstants.ARM_MASS_KG),
			ElbowConstants.ARM_LENGTH,
			ElbowConstants.BACKWARD_ANGLE_LIMIT.getRadians(),
			ElbowConstants.FORWARD_ANGLE_LIMIT.getRadians(),
			false,
			ElbowConstants.PresetPositions.STARTING.ANGLE.getRadians()
		) {

		};
		this.motor = new SingleJointedArmSimulation(armSim);
		controller = new PIDController(ElbowSimulationConstants.P, ElbowSimulationConstants.I, ElbowSimulationConstants.D);
		TalonFXConfiguration config = new TalonFXConfiguration();
		config.Slot0.kP = controller.getP();
		config.Slot0.kI = controller.getI();
		config.Slot0.kD = controller.getD();
		motor.applyConfiguration(config);
	}

	@Override
	public Rotation2d getPosition() {
		return motor.getPosition();
	}

	public Rotation2d getVelocity() {
		return motor.getVelocity();
	}


	public void goToAngle(Rotation2d targetAngle) {
		PositionVoltage pos = new PositionVoltage(targetAngle.getRotations());
		motor.setControl(pos);
	}

	public void stop() {
		goToAngle(getPosition());
	}


	@Override
	public boolean isAtPosition(Rotation2d position) {
		return (getPosition() == position);
	}

}
