package training.subsystems.RobotArm.elbow;

import edu.wpi.first.math.geometry.Rotation2d;
import org.littletonrobotics.junction.Logger;
import utils.GBSubsystem;

public class Elbow extends GBSubsystem {

	private ElbowInputsAutoLogged inputs;
	private Rotation2d position;
	private static Elbow instance;
	private final IElbow current;

	private Elbow() {
		this.current = ElbowFactory.create();
		this.position = new Rotation2d(ElbowConstants.BIGINNING_POSITION);
		this.inputs = new ElbowInputsAutoLogged();
	}

	public static Elbow getInstance() {
		if (instance == null)
			instance = new Elbow();
		return instance;
	}

	public void goToAngle(Rotation2d position) {
		current.goToAngle(position);
	}

	public Rotation2d getPosition() {
		return current.getPosition();
	}

	public Rotation2d getVelocity() {
		return current.getVelocity();
	}


	public boolean isAtPosition(Rotation2d position) {
		return current.isAtPosition(position);
	}

	public void stayInPlace(Rotation2d position) {
		current.stayInPlace(position);
	}

	@Override
	protected String getLogPath() {
		return "Elbow/";
	}

	@Override
	protected void subsystemPeriodic() {
		current.updateInputs(inputs);
		Logger.processInputs(getLogPath(), inputs);
	}

}

