package training.subsystems.Arm.Elbow;

import edu.wpi.first.math.geometry.Rotation2d;
import org.littletonrobotics.junction.Logger;
import utils.GBSubsystem;

public class Elbow extends GBSubsystem {

	private IElbow iElbow;
	private ElbowInputsAutoLogged inputs;

	public Elbow() {
		this.iElbow = ElbowFactory.create();
		this.inputs = new ElbowInputsAutoLogged();
	}

	@Override
	protected String getLogPath() {
		return "Elbow/";
	}

	@Override
	protected void subsystemPeriodic() {
		iElbow.updateInputs(inputs);
		Logger.processInputs("Elbow inputs", inputs);
	}


	public void setPower(double power) {
		iElbow.setPower(power);
	}

	public boolean isAtPosition(Rotation2d target) {
		return Math.abs(iElbow.getPosition().getDegrees() - target.getDegrees()) <= ElbowConstants.TOLERANCE;
	}

	public void moveToPosition(Rotation2d targetPosition) {
		iElbow.moveToPosition(targetPosition);
	}

	public void stayAtPosition() {
		moveToPosition(iElbow.getPosition());
	}

	public double getPosition(){
		return iElbow.getPosition().getDegrees();
	}


}
