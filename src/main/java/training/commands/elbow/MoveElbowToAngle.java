package training.commands.elbow;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import training.subsystems.RobotArm.elbow.Elbow;
import training.subsystems.RobotArm.elbow.IElbow;

public class MoveElbowToAngle extends Command {

    private Rotation2d position;
    private Elbow elbow;

    public MoveElbowToAngle(Rotation2d position, Elbow elbow) {
        this.position = position;
        this.elbow = elbow;
    }

    @Override
    public void execute() {
        elbow.goToAngle(position);
    }


//    @Override
//    public boolean isFinished() {
//        return elbow.isAtPosition(position);
//    }

    @Override
    public void end(boolean interrupted) {
        elbow.stayInPlace(position);
    }

}

