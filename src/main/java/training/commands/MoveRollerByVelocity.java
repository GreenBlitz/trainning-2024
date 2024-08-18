package training.commands;

import edu.wpi.first.wpilibj2.command.Command;
import org.littletonrobotics.junction.Logger;
import training.Robot;
import training.subsystems.Arm.Roller.Roller;
import training.subsystems.Arm.Wrist.WristConstants;

public class MoveRollerByVelocity extends Command {
    private final Roller roller;
    private final double velocity;
    public MoveRollerByVelocity(Robot robot, double velocity) {
        this.roller = robot.getRoller();
        this.velocity = velocity;
    }

    @Override
    public void initialize() {

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

    }
}
