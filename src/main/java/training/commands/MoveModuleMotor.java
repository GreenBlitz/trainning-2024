package training.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import training.Robot;
import training.subsystems.SwerveModule;


public class MoveModuleMotor extends Command {

    private final SwerveModule module;
    private final Timer timer1;

    public MoveModuleMotor(SwerveModule module) {
        this.module = module;
        timer1 = new Timer();
        addRequirements(module);
    }

    @Override
    public void initialize() {
        module.moveBoth(0.5);
        timer1.start();
    }

    @Override
    public void execute() {

    }

    @Override
    public boolean isFinished() {
        return timer1.hasElapsed(5);
    }

    @Override
    public void end(boolean interrupted) {
        module.stopBoth();
        timer1.restart();
    }
}
