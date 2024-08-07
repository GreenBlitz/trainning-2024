package utils;

import edu.wpi.first.wpilibj2.command.CommandScheduler;
import org.littletonrobotics.junction.LoggedRobot;
import utils.logger.LoggerFactory;
import utils.simulation.SimulationManager;

public abstract class DefaultRobotManager extends LoggedRobot {

	@Override
	public final void robotInit() {
		LoggerFactory.initializeLogger();
		this.trainingInit();
	}

	@Override
	public final void robotPeriodic() {
		CommandScheduler.getInstance().run();
		trainingPeriodic();
	}

	@Override
	public final void simulationPeriodic() {
		SimulationManager.updateRegisteredSimulations();
	}

	public void trainingInit() {}

	public void trainingPeriodic() {}

}
