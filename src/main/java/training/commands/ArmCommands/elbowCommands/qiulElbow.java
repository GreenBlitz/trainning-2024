package training.commands.ArmCommands.elbowCommands;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import training.subsystems.ArmSubsystems.elbowSubsystem.Elbow;

public class qiulElbow extends Command {

    private final Elbow elbow;
    private final Rotation2d targetPosition;

    public qiulElbow(Rotation2d targetPosition) {
        this.elbow = Elbow.getInstance();
        this.targetPosition = targetPosition;
    }

    @Override
    public void execute() {
        elbow.goToPosition(targetPosition);
    }
    
}
