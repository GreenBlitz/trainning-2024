package training.commands;

import training.subsystems.SwerveModule;

public class MoveLinearMotorByVoltage extends SwerveModuleCommand {
    private double voltage;

    public MoveLinearMotorByVoltage(double voltage) {
        this.voltage = voltage;
    }

    @Override
    public void execute() {
        SwerveModule.getInstance().setVoltageLinear(voltage);
    }

    @Override
    public void end(boolean interrupted) {
        SwerveModule.getInstance().stop();
    }

}