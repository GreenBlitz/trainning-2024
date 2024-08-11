package training.commands.roller;

import edu.wpi.first.wpilibj2.command.Command;
import training.subsystems.roller.Roller;

public class MoveToSpeedRoller extends Command {

    private double targetSpeed;

    public void MoveToSpeedSpeed(double targetSpeed){
        this.targetSpeed = targetSpeed;
    }


    public boolean isFinished(){
        return Roller.getInstance().isAtVelocity(targetSpeed);
    }

    public void end(boolean interrupted){
        Roller.getInstance().stop();
    }
}