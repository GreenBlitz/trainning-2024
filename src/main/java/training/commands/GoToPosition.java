package training.commands;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import training.Robot;
import training.subsystems.SwerveModule;

public class GoToPosition extends Command {


    private final SwerveModule module;
    private Rotation2d position;

    public GoToPosition(Robot robot, Rotation2d position) {
        module = robot.getModule();
        this.position = position;
        addRequirements(module);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        if (module.getHorizontalPosition().getDegrees() < position.getDegrees()) {
            if (module.searchPosition(position, 5)){
                module.moveHorizontal(0.03);
            }
            else {
                module.moveHorizontal(0.3);
            }
        }
        else {
            if (module.searchPosition(position, 5)){
                module.moveHorizontal(-0.03);
            }
            else {
                module.moveHorizontal(-0.3);
            }
        }
        System.out.println(module.getHorizontalPosition().getDegrees());

    }

    @Override
    public boolean isFinished() {
        return module.searchPosition(position, 1);
    }

    @Override
    public void end(boolean interrupted) {
        module.stopBoth();

    }


}
