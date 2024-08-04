package training;
import Commands.java;
import utils.DefaultRobotManager;

public class TrainingRobotManager extends DefaultRobotManager {

    private Robot robot;

    @Override
    public void trainingInit() {
        this.robot = new Robot();
        this.keyboardController = new KeyboardController();

        keyboardController.A.onTrue(Commands.moveToPosition(Rotation2d.fromDegrees(0)));
        keyboardController.W.onTrue(Commands.moveToPosition(Rotation2d.fromDegrees(324)));
        keyboardController.D.onTrue(Commands.moveToPosition(Rotation2d.fromDegrees(20)));
        keyboardController.S.onTrue(Commands.moveToPosition(Rotation2d.fromDegrees(80)));
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
