package training.subsystems.ArmSubsystems.elbowSubsystem;

import edu.wpi.first.math.geometry.Rotation2d;
import utils.GBSubsystem;
import training.subsystems.ArmSubsystems.elbowSubsystem.ElbowInputsAutoLogged;

public class Elbow extends GBSubsystem {

	private IElbow iElbow;
	private ElbowInputsAutoLogged inputs;

	private static Elbow instance;

	private Elbow() {
		this.iElbow = ElbowFactory.create();
		this.inputs=new ElbowInputsAutoLogged();
	}

	public static Elbow getInstance() {
		if (instance == null) {
			instance = new Elbow();
		}
		return instance;
	}

	@Override
	protected String getLogPath() {
		return null;
	}

	@Override
	protected void subsystemPeriodic() {}

	public boolean isAtTargetPosition(Rotation2d targetAngle, Rotation2d tolerance) {
		return Math.abs(inputs.position.minus(targetAngle).getDegrees()) <= tolerance.getDegrees();
	}

	public void goToPosition(Rotation2d targetPosition) {
		iElbow.goToPosition(targetPosition);
	}

	public void stayAtPosition() {
		goToPosition(inputs.position);
	}

	public void setVoltage(double voltage) {
		iElbow.setVoltage(voltage);
	}

	public void setPower(double power) {
		iElbow.setPower(power);
	}



}
