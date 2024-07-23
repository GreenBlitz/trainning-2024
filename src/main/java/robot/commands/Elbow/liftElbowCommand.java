package robot.commands.Elbow;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

public class liftElbowCommand extends SequentialCommandGroup {
    public liftElbowCommand() {
        addCommands(new upElbowCommand(), new WaitCommand(0.1), new downElbowCommand());
    }

    public liftElbowCommand(Rotation2d angle) {
        addCommands(new upElbowCommand(angle), new WaitCommand(0.1), new downElbowCommand(angle));
    }
}
