package frc.robot;

import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.PrintCommand;
import frc.utils.KeyboardController;
import frc.utils.logger.LoggerFactory;
import org.littletonrobotics.junction.LoggedRobot;

public class RobotManager extends LoggedRobot {

    private Robot robot;

    @Override
    public void robotInit() {
        LoggerFactory.initializeLogger();

        this.robot = new Robot();
    }

    @Override
    public void robotPeriodic() {
        CommandScheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {
        // schedule your command...
    }

    @Override
    public void teleopExit() {
        // cancel your command...
    }

}
