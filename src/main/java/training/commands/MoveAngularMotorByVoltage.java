package training.commands;

import training.subsystems.SwerveModule;
import utils.GBCommand;

public class MoveAngularMotorByVoltage extends SwerveModuleCommand {
    private double voltage;
    public MoveAngularMotorByVoltage(double voltage){
        this.voltage = voltage;
    }

    @Override
    public void execute() {
        SwerveModule.getInstance().setVoltageAngular(voltage);
    }
    @Override
    public void end(boolean interrupted){
        SwerveModule.getInstance().stop();
    }


}
