package training.commands;

import training.subsystems.SwerveModule;

public class RotateModuleToAngle extends SwerveModuleCommand {

    @Override
    public void execute() {
        SwerveModule.getInstance().setVoltageAngular(1);
    }

    @Override
    public boolean isFinished() {
        return SwerveModule.getInstance().isItAtAngle(SwerveModule.getInstance().getAngle());
    }

    @Override
    public void end(boolean interrupted) {
        SwerveModule.getInstance().stop();
    }

}