package subsystems.elbow;

import edu.wpi.first.math.geometry.Rotation2d;
import org.littletonrobotics.junction.Logger;
import utils.GBSubsystem;


public class Elbow extends GBSubsystem {

	private static Elbow instance;
	private IElbow iElbow;
	private ElbowInputsAutoLogged inputs;
	private Rotation2d targetAngle;

	private Elbow() {
		this.targetAngle = ElbowConstants.PresetPositions.STARTING.ANGLE;
		this.iElbow = ElbowFactory.create();
		this.inputs = new ElbowInputsAutoLogged();
		this.iElbow.updateInputs(inputs);
	}

	public static Elbow getInstance() {
		if (instance == null) {
			instance = new Elbow();
		}
		return instance;
	}

	public void setPower(double power) {
		iElbow.setPower(power);
	}

	public void goToPosition(Rotation2d angle) {
		this.targetAngle = angle;
	}

	public boolean isAtAngle(Rotation2d angle) {
		return Math.abs(inputs.angle.getRadians() - angle.getRadians()) <= ElbowConstants.ANGLE_TOLERANCE.getRadians();
	}

	public ElbowInputs getInputs() {
		ElbowInputs clonesInputs = new ElbowInputs();
		clonesInputs.angle = inputs.angle;
		clonesInputs.velocity = inputs.velocity;
		return clonesInputs;
	}

	@Override
	protected String getLogPath() {
		return "ELBOW/";
	}

	@Override
	protected void subsystemPeriodic() {
		iElbow.goToPosition(targetAngle);
		iElbow.updateInputs(inputs);
		Logger.processInputs("elbow", inputs);
	}

}
