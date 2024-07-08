package training;

import edu.wpi.first.math.geometry.Rotation2d;
import training.subsystems.module.ModuleCommands;
import utils.DefaultRobotManager;
import utils.KeyboardController;

public class TrainingRobotManager extends DefaultRobotManager {

    private Robot robot;
    private KeyboardController keyboardController;

    @Override
    public void trainingInit() {
        this.robot = new Robot();
        this.keyboardController = new KeyboardController();
        
        keyboardController.A.onTrue(ModuleCommands.pointWheel(Rotation2d.fromDegrees(150)));
        keyboardController.B.onTrue(ModuleCommands.pointWheel(Rotation2d.fromDegrees(60)));
        keyboardController.D.onTrue(ModuleCommands.pointWheel(Rotation2d.fromDegrees(20)));
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
