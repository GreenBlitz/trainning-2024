package training.commands.elbow;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.util.sendable.SendableBuilder;
import edu.wpi.first.wpilibj2.command.Command;
import training.subsystems.RobotArm.ElbowSubsystem;

public class MoveElbowToAngle extends Command {
    private Rotation2d position;
    public MoveElbowToAngle(Rotation2d position){
       this.position = position;
    }

    @Override
    public void initSendable(SendableBuilder builder) {
        super.initSendable(builder);
    }

    @Override
    public void execute() {
        ElbowSubsystem.getInstance().goToPosition(position);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        super.end(interrupted);
    }
}

