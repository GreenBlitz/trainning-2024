package training;

import training.commands.ArmCommands.elbowCommands.ElbowDefultCommand;
import training.commands.ArmCommands.elbowCommands.MoveElbow;
import training.commands.ArmCommands.wristCommands.MoveWrist;
import training.commands.ArmCommands.rollerCommands.RollClockwise;
import training.commands.ArmCommands.rollerCommands.RollCounterClockwise;
import training.commands.ArmCommands.wristCommands.WristDefultCommand;
import training.subsystems.ArmSubsystems.elbowSubsystem.Elbow;
import training.subsystems.ArmSubsystems.elbowSubsystem.ElbowConstants;
import training.subsystems.ArmSubsystems.wristSubsystem.Wrist;
import training.subsystems.ArmSubsystems.wristSubsystem.WristConstants;
import utils.DefaultRobotManager;
import utils.joysticks.SmartJoystick;

public class TrainingRobotManager extends DefaultRobotManager {

	private Robot robot;
	private SmartJoystick smartJoystick;

	@Override
	public void trainingInit() {
		this.robot = new Robot();
		this.smartJoystick = new SmartJoystick(RobotConstants.ID_OF_SMART_JOYSTICK);

		smartJoystick.B.onTrue(new MoveElbow(ElbowConstants.ELBOW_CLIMBING_POSITION));
		smartJoystick.A.onTrue(new MoveElbow(ElbowConstants.ELBOW_CLIMBING_POSITION));

		smartJoystick.Y.onTrue(new MoveWrist(WristConstants.WRIST_CLIMBING_POSITION));
		smartJoystick.X.onTrue(new MoveWrist(WristConstants.WRIST_STARTING_POSITION));

		smartJoystick.R1.whileTrue(new RollClockwise());
		smartJoystick.R2.whileTrue(new RollCounterClockwise());

		Elbow.getInstance().setDefaultCommand(new ElbowDefultCommand());
		Wrist.getInstance().setDefaultCommand(new WristDefultCommand());
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
