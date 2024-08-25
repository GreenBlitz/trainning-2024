package training.subsystems.RobotArm.elbow;

import edu.wpi.first.math.geometry.Rotation2d;
import org.littletonrobotics.junction.Logger;
import utils.GBSubsystem;

public class Elbow extends GBSubsystem {

	private ElbowInputsAutoLogged inputs;
	private Rotation2d position;
	private static Elbow instance;
	private final IElbow iElbow;

	private Elbow() {
		this.iElbow = ElbowFactory.create();
		this.position = new Rotation2d(ElbowConstants.BEGINNING_POSITION);
		this.inputs = new ElbowInputsAutoLogged();
	}

	public static Elbow getInstance() {
		if (instance == null)
			instance = new Elbow();
		return instance;
	}

	public void goToAngle(Rotation2d position) {
		iElbow.goToAngle(position);
	}

	public Rotation2d getPosition() {
		return inputs.position;
	}

	public Rotation2d getVelocity() {
		return inputs.velocity;
	}

	public boolean isAtPosition(Rotation2d position) {
		return Math.abs(getPosition().minus(position).getDegrees()) <= ElbowConstants.TOLERANCE.getDegrees();
	}

	public void stayInPlace(Rotation2d position) {
		iElbow.stayInPlace();
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

}

