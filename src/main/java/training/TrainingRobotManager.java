package training;

import edu.wpi.first.wpilibj.Joystick;
import training.Elbow.LiftElbowCommand;
import training.Roller.NoteOutCommand;
import training.Wrist.WristCommandBuilder;
import utils.DefaultRobotManager;
import utils.KeyboardController;

public class TrainingRobotManager extends DefaultRobotManager {

    private Robot robot;
    private final KeyboardController keyboardController;
    private Joystick joystick;

    public TrainingRobotManager() {
        this.keyboardController = new KeyboardController();
        joystick = new Joystick(0);
    }

    @Override
    public void trainingInit() {
        this.robot = new Robot();
        keyboardController.A.onTrue(new NoteOutCommand());
        keyboardController.B.onTrue(new LiftElbowCommand());
        keyboardController.C.onTrue(new WristCommandBuilder().MoveUpWristCommand());
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
