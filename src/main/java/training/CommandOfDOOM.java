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
        timer1.restart();
        module.moveVertical(0.9);
        module.moveHorizontal(0.9);

    }

    @Override
    public void execute() {

    }

    @Override
    public boolean isFinished() {
        if (timer1.hasElapsed(2)){
            return true;
        }
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        module.stopBoth();
    }
}
