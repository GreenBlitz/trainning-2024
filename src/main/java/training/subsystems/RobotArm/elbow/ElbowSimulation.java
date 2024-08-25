package training.subsystems.RobotArm.elbow;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.PositionVoltage;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.simulation.SingleJointedArmSim;
import org.littletonrobotics.junction.Logger;
import utils.simulation.SingleJointedArmSimulation;

public class ElbowSimulation implements IElbow {

	private SingleJointedArmSimulation motor;
	private Rotation2d position;
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
		TalonFXConfiguration config = new TalonFXConfiguration();
		config.Slot0.kP = ElbowConstants.KP;
		config.Slot0.kI = ElbowConstants.KI;
		config.Slot0.kD = ElbowConstants.KD;
		motor.applyConfiguration(config);
	}

	public Rotation2d getPosition() {
		return motor.getPosition();
	}

	public void goToAngle(Rotation2d targetAngle) {
		PositionVoltage pos = new PositionVoltage(targetAngle.getRotations());
		motor.setControl(pos);
	}

	public void stop() {
		goToAngle(getPosition());
	}

	@Override
	public void stayInPlace() {
		goToAngle(getPosition());
	}

	@Override
	public void updateInputs(ElbowInputsAutoLogged inputs) {
		inputs.position = getPosition();
	}

}
