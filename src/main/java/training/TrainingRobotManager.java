package training;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import training.commands.ArmCommands.elbowCommands.ElbowStayInPlace;
import training.commands.ArmCommands.elbowCommands.MoveElbow;
import training.commands.ArmCommands.wristCommands.MoveWrist;
import training.commands.ArmCommands.rollerCommands.RollClockwise;
import training.commands.ArmCommands.rollerCommands.RollCounterClockwise;
import training.commands.ArmCommands.wristCommands.StopWrist;
import training.subsystems.ArmSubsystems.elbow.Elbow;
import training.subsystems.ArmSubsystems.elbow.ElbowConstants;
import training.subsystems.ArmSubsystems.wrist.Wrist;
import training.subsystems.ArmSubsystems.wrist.WristConstants;
import utils.DefaultRobotManager;
import utils.commands.LoggedDashboardCommand;
import utils.joysticks.SmartJoystick;

import java.util.function.Consumer;

public class TrainingRobotManager extends DefaultRobotManager {

	private Robot robot;
	private SmartJoystick smartJoystick;

	public void configJoystick(Robot robot) {
		smartJoystick.B.onTrue(new MoveElbow(ElbowConstants.SCORE_POSITION, robot.getElbow()));
		smartJoystick.A.onTrue(new MoveElbow(ElbowConstants.SAFE_POSITION, robot.getElbow()));

		smartJoystick.R1.whileTrue(new RollClockwise(robot.getRoller()));
		smartJoystick.L2.whileTrue(new RollCounterClockwise(robot.getRoller()));
	}

	public void configDefaultCommands(Elbow elbow, Wrist wrist) {
		elbow.setDefaultCommand(new ElbowStayInPlace(robot.getElbow()));
		wrist.setDefaultCommand(new StopWrist(robot.getWrist()));
	}

	@Override
	public void trainingInit() {
		this.robot = new Robot();

		this.smartJoystick = new SmartJoystick(GlobalConstants.MAIN_JOYSTICK_PORT);
		 configJoystick(robot);
		 configDefaultCommands(robot.getElbow(), robot.getWrist());

	}

	@Override
	public void trainingPeriodic() {
		// add stuff...
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
