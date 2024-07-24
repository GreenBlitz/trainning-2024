package training;

import edu.wpi.first.wpilibj.Joystick;
import training.commands.Elbow.liftElbowCommand;
import training.commands.Roller.diskOutCommand;
import training.commands.WristCommands;
import utils.DefaultRobotManager;
import utils.KeyboardController;

public class TrainingRobotManager extends DefaultRobotManager {

    private Robot robot;
    private KeyboardController keyboardController = new KeyboardController();
    private Joystick joystick = new Joystick(0);

    @Override
    public void trainingInit() {
        this.robot = new Robot();
        keyboardController.A.onTrue(new diskOutCommand());
        keyboardController.B.onTrue(new liftElbowCommand());
        keyboardController.C.onTrue(new WristCommands().MoveUpWristCommand);
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
