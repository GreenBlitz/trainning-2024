package training;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import training.subsystems.SubsystemOfDOOM;


public class CommandOfDOOM extends Command {

    private final SubsystemOfDOOM module;
    private final Timer timer1;

    public CommandOfDOOM(Robot robot) {
        module = robot.getModule();
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
