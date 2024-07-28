package training.commands.Elbow;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

public class LiftElbowCommand extends SequentialCommandGroup {
    public LiftElbowCommand() {
        addCommands(new UpElbowCommand(), new WaitCommand(0.1), new DownElbowCommand());
    }

    public LiftElbowCommand(Rotation2d angle) {
        addCommands(new UpElbowCommand(angle), new WaitCommand(0.1), new DownElbowCommand(angle));
    }
}
