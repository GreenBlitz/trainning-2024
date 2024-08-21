package training;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import training.commands.Arm.Elbow.MoveElbow;
import training.subsystems.Arm.Elbow.Elbow;
import training.subsystems.Arm.Elbow.ElbowConstants;
import training.subsystems.Arm.Elbow.NeoElbow.NeoElbow;
import utils.KeyboardController;
import utils.SmartJoystick;
import utils.DefaultRobotManager;
import utils.commands.LoggedDashboardCommand;

import java.util.function.Consumer;


public class TrainingRobotManager extends DefaultRobotManager {

	private SmartJoystick joystick;
	private Robot robot;
	private KeyboardController keyboardController;

	public TrainingRobotManager() {
		this.joystick = new SmartJoystick(GlobalConstants.JOYSTICK_PORT);
	}


	@Override
	public void trainingInit() {
		this.robot = new Robot();
//		joystick.A.onTrue(new MoveElbow(robot.getElbow(), ElbowConstants.PresetPositions.SCORE.angle));
//		joystick.B.onTrue(new MoveElbow(robot.getElbow(), ElbowConstants.PresetPositions.INTAKE.angle));
		Consumer<Double> configKG = kg -> robot.getElbow().setVoltage(kg);
		joystick.A.whileTrue(new LoggedDashboardCommand("KG", configKG, robot.getElbow()));
		joystick.X.whileTrue(new MoveElbow(robot.getElbow(), Rotation2d.fromDegrees(45)));
		joystick.B.whileTrue(new MoveElbow(robot.getElbow(), Rotation2d.fromDegrees(-45)));
		joystick.Y.whileTrue(new InstantCommand(() -> robot.getElbow().setVoltage(0.1), robot.getElbow()));
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
