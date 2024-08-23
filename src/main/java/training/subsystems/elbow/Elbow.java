package training.subsystems.elbow;

import edu.wpi.first.math.geometry.Rotation2d;
import org.littletonrobotics.junction.Logger;
import utils.GBSubsystem;

public class Elbow extends GBSubsystem {

	private static Elbow instance;

	private final IElbow elbow;

	private ElbowInputsAutoLogged inputs;

	private Elbow() {
		this.elbow = ElbowFactory.create();
		this.inputs = new ElbowInputsAutoLogged();
	}

	public static void init() {
		if (instance == null) {
			instance = new Elbow();
		}
	}

	public static Elbow getInstance() {
		init();
		return instance;
	}

	public Rotation2d getPosition() {
		return inputs.position;
	}

	public Rotation2d getVelocity() {
		return inputs.velocity;
	}

	public void goToAngle(Rotation2d targetAngle) {
		elbow.goToAngle(targetAngle);
	}

	public boolean isAtAngle(Rotation2d targetAngle) {
		return Math.abs(targetAngle.getRotations() - inputs.position.getRotations()) <= ElbowConstants.TOLERANCE.getRotations();
	}

	public void stayAtPosition() {
		goToAngle(getPosition());
	}

	@Override
	protected String getLogPath() {
		return "Elbow/";
	}

	@Override
	protected void subsystemPeriodic() {
		elbow.updateInputs(inputs);
		Logger.processInputs("Elbow/", inputs);
		Logger.recordOutput("Elbow/Position",getPosition().getDegrees());
	}
}