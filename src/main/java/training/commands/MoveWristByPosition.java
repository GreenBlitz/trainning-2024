package training.commands;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import org.littletonrobotics.junction.Logger;
import training.Robot;
import training.subsystems.Arm.Wrist.Wrist;
import training.subsystems.Arm.Wrist.WristConstants;

public class MoveWristByPosition extends Command {

    private final Wrist wrist;

    private final Rotation2d position;

    public MoveWristByPosition(Robot robot, Rotation2d position) {
        this.wrist = robot.getWrist();
        this.position = position;
        addRequirements(wrist);
    }


    @Override
    public void execute() {
        wrist.moveToAngle(position);
        Logger.recordOutput("Wrist/Distance", Math.abs(wrist.getPosition().getRotations() - position.getRotations()));
    }

    @Override
    public boolean isFinished() {
        return wrist.isAtAngle(position);
    }

    @Override
    public void end(boolean interrupted) {
        wrist.standInPlace();
    }
}
