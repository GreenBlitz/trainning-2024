package training.commands;

import training.subsystems.SwerveModule;
import utils.GBCommand;

public abstract class SwerveModuleCommand extends GBCommand {

    SwerveModule swerveModule;

    public SwerveModuleCommand() {
        swerveModule = SwerveModule.getInstance();
        require(swerveModule);
    }
}