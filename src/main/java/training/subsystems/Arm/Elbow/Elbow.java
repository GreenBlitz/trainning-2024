package training.subsystems.Arm.Elbow;

import edu.wpi.first.math.geometry.Rotation2d;
import org.littletonrobotics.junction.Logger;
import utils.GBSubsystem;

public class Elbow extends GBSubsystem {

	private final IElbow iElbow;
	private ElbowInputsAutoLogged inputs;

	public Elbow(IElbow elbow) {
		this.iElbow = elbow;
		inputs = new ElbowInputsAutoLogged();
	}

	@Override
	protected String getLogPath() {
		return "Elbow/";
	}

	@Override
	protected void subsystemPeriodic() {
		iElbow.updateInputs(inputs);
		Logger.processInputs(getLogPath(), inputs);
	}

	public void setPower(double power) {
		iElbow.setPower(power);
	}

	public boolean isAtPosition(Rotation2d target) {
		return Math.abs(inputs.position.getDegrees() - target.getDegrees())
				<= ElbowConstants.TOLERANCE.getDegrees();
	}

	public void moveToPosition(Rotation2d targetPosition) {
		iElbow.moveToPosition(targetPosition);
	}

	public void stayAtPosition() {
		moveToPosition(inputs.position);
	}

	public Rotation2d getPosition() {
		return iElbow.getPosition();
	}

	public void setVoltage(double voltage){
		iElbow.setVoltage(voltage);
	}

}
