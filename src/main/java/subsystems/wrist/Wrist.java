package subsystems.wrist;

import edu.wpi.first.math.geometry.Rotation2d;
import org.littletonrobotics.junction.Logger;
import utils.GBSubsystem;

public class Wrist extends GBSubsystem {

	private static Wrist instance;
	private IWrist iWrist;
	private WristInputsAutoLogged inputs;
	private Rotation2d targetAngle;

	private Wrist() {
		this.iWrist = WristFactory.create();
		this.inputs = new WristInputsAutoLogged();
		this.targetAngle = WristConstants.PresetPositions.STARTING.ANGLE;
		this.iWrist.updateInputs(inputs);
	}

	public static Wrist getInstance() {
		if (instance == null) {
			instance = new Wrist();
		}
		return instance;
	}

	public void goToPosition(Rotation2d position) {
		this.targetAngle = position;
	}

	public boolean isAtAngle(Rotation2d angle) {
		return Math.abs(inputs.angle.getRadians() - angle.getRadians()) <= WristConstants.ANGLE_TOLERANCE.getRadians();
	}

	@Override
	protected String getLogPath() {
		return "WRIST/";
	}

	@Override
	protected void subsystemPeriodic() {
		iWrist.goToPosition(targetAngle);
		iWrist.updateInputs(inputs);
		Logger.processInputs("wrist", inputs);
	}

}
