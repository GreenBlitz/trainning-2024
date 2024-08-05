package utils.logger;

import com.ctre.phoenix6.SignalLogger;
import org.littletonrobotics.junction.Logger;
import org.littletonrobotics.junction.networktables.NT4Publisher;
import org.littletonrobotics.junction.wpilog.WPILOGWriter;
import training.TrainingRobotManager;

import java.nio.file.Path;

public class LoggerFactory {

	public static void initializeLogger() {
		if (TrainingRobotManager.isSimulation()) {
			startSimulationLogger();
		} else if (TrainingRobotManager.isReal()) {
			startRealLogger();
		}
	}

	private static void startRealLogger() {
		SignalLogger.enableAutoLogging(true); // must be true to BusStatus to work

		if (LogSaveSpot.USB.isWritable()) {
			startLoggerOnUSB();
		} else {
			startLoggerOnRoborio();
			reportNoUSBFound();
		}
	}

	private static void reportNoUSBFound() {
		Logger.recordOutput("Didn't find USB");
	}

	private static void startSimulationLogger() {
		startNonReplayLogger(LogSaveSpot.COMPUTER);
	}

	private static void startLoggerOnUSB() {
		startNonReplayLogger(LogSaveSpot.USB);
	}

	private static void startLoggerOnRoborio() {
		startNonReplayLogger(LogSaveSpot.ROBORIO);
	}


	private static void startNonReplayLogger(LogSaveSpot logSaveSpot) {
		setLoggingPath(logSaveSpot.getSavePath());
		Logger.addDataReceiver(new NT4Publisher());
		Logger.start();
		Logger.recordOutput("Logged In", logSaveSpot);
	}

	private static void setLoggingPath(Path path) {
		String stringPath = path.toString();
		SignalLogger.setPath(stringPath);
		Logger.addDataReceiver(new WPILOGWriter(stringPath));
	}

}
