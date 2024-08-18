package training.Elbow.SimulationElbow;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.simulation.SingleJointedArmSim;
import org.littletonrobotics.junction.Logger;
import training.Elbow.ElbowInputsAutoLogged;
import training.Elbow.IElbow;
import utils.simulation.SimpleMotorSimulation;
import utils.simulation.SingleJointedArmSimulation;

public class SimulationElbow implements IElbow {

//	private final SingleJointedArmSimulation arm;
	private final SimpleMotorSimulation arm;

	public SimulationElbow() {
		this.arm = new SimpleMotorSimulation();
//		this.arm = new SingleJointedArmSimulation(
//			new SingleJointedArmSim(
//				SimulationElbowConstants.GEARBOX,
//				SimulationElbowConstants.GEARING,
//				SingleJointedArmSim.estimateMOI(SimulationElbowConstants.LENGTH_METERS, SimulationElbowConstants.MASS),
//				SimulationElbowConstants.LENGTH_METERS,
//				SimulationElbowConstants.MINIMUM_ANGLE.getRadians(),
//				SimulationElbowConstants.MAXIMUM_ANGLE.getRadians(),
//				true,
//				0
//			)
//		);
		arm.applyConfiguration(SimulationElbowConstants.config);

	}

	@Override
	public void moveToAngle(Rotation2d targetAngle) {
		double feedForwardOutputVoltage = SimulationElbowConstants.FEEDFORWARD
			.calculate(arm.getPosition().getRadians(), arm.getVelocity().getRadians());
		double PIDOutputVoltage = SimulationElbowConstants.CONTROLLER.calculate(arm.getPosition().getRadians(), targetAngle.getRadians());

		Logger.recordOutput("Elbow/FF out: ", Rotation2d.fromRadians(feedForwardOutputVoltage));
		Logger.recordOutput("Elbow/PID out: ", Rotation2d.fromRadians(PIDOutputVoltage));

		arm.setPower(
				PIDOutputVoltage + feedForwardOutputVoltage
		);
	}

	@Override
	public void updateInputs(ElbowInputsAutoLogged inputs) {
		inputs.outputCurrent = arm.getCurrent();
		inputs.position = arm.getPosition();
		inputs.velocity = arm.getVelocity();
	}

}
