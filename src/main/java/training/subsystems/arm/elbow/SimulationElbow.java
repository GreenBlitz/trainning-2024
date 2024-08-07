package training.subsystems.arm.elbow;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.simulation.SingleJointedArmSim;
import edu.wpi.first.wpilibj.simulation.SingleJointedArmSim;
import edu.wpi.first.math.system.plant.DCMotor;

public class SimulationElbow implements  IElbow {

	private final SingleJointedArmSim elbowSimulation;
	private final PIDController controller;
	
	public SimulationElbow() {
		elbowSimulation = new SingleJointedArmSim(
				DCMotor.getFalcon500(SimulationElbowConstants.NUMBER_OF_MOTORS),
				
				SimulationElbowConstants.GEAR_RATIO,
				SingleJointedArmSim.estimateMOI(
						SimulationElbowConstants.ARM_LENGTH,
						SimulationElbowConstants.ARM_MASS_KG
				),
				SimulationElbowConstants.ARM_LENGTH,
				SimulationElbowConstants.BACKWARD_ANGLE_LIMIT.getRadians(),
				SimulationElbowConstants.FORWARD_ANGLE_LIMIT.getRadians(),
				false,
				SimulationElbowConstants.PresetPositions.STARTING.ANGLE.getRadians()
		);
		controller = SimulationElbowConstants.SIMULATION_PID;
	}
	
	@Override
	public Rotation2d getCurrentAngle() {
		 return Rotation2d.fromRadians(elbowSimulation.getAngleRads());
	}
	
	@Override
	public void setPower(double power) {
		elbowSimulation.setInputVoltage(power * Constants.BATTERY_VOLTAGE);
	}
	
	@Override
	public Rotation2d getCurrentVelocity() {
		return  elbowSimulation.getVelocityRadPerSec() / SimulationElbowConstants.
	}
	
	@Override
	public void moveToAngle(Rotation2d angle) {
	
	}
	
	@Override
	public void stayInPlace() {
	
	}
}
	
	
	@Override
	public Rotation2d getCurrentAngle() {
		return null;
	}
	
	@Override
	public void setPower(double power) {
	
	}
	
	@Override
	public boolean isAtAngle(Rotation2d angle) {
		return false;
	}
	
	@Override
	public Rotation2d getCurrentVelocity() {
		return null;
	}
	
	@Override
	public void moveToAngle(Rotation2d angle) {
	
	}
	
	@Override
	public void stayInPlace() {
	
	}
}
