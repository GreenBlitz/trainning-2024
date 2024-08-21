package training.commands;

import edu.wpi.first.wpilibj2.command.Command;
import training.Robot;
import training.subsystems.Arm.Roller.Roller;

public class MoveRollerByVelocity extends Command {

    private final Roller roller;
    private final double velocity;

    public MoveRollerByVelocity(Robot robot, double velocity) {
        this.roller = robot.getRoller();
        this.velocity = velocity;
    }


    @Override
    public void execute() {
        roller.setVelocity(velocity);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        roller.setVelocity(0);
    }
}
