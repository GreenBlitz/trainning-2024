package training.commands.roller;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import training.subsystems.RobotArm.Roller;

public class MoveRollerAtSpeed extends Command {

    private Rotation2d velocity;

    public MoveRollerAtSpeed (Rotation2d velocity) {
        this.velocity = velocity;


    }
    public void initialize () {
        super.initialize();
    }

    public void execute () {
        Roller.getInstance().moveAtSpeed(velocity);

    }

    public boolean isFinished () {
        return false;
    }

    public void end ( boolean interrupted){
        Roller.getInstance().moveAtSpeed(Rotation2d.fromRadians(0));
    }

}
