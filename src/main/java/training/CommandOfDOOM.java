package training;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import training.subsystems.SubsystemOfDOOM;


public class CommandOfDOOM extends Command {

    private SubsystemOfDOOM module;
    private Timer timer1;
    public CommandOfDOOM(Robot robot){
        module = robot.getModule();
        timer1 = new Timer();
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
        if (timer1.hasElapsed(5)){
            return true;
        }
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        module.stopBoth();
        timer1.restart();
    }
}
