package robot.commands.Roller;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import static robot.commands.Roller.Constants.ROLLER_ROLLING_TIME_SEC;

public class diskOutCommand extends SequentialCommandGroup {
    public diskOutCommand() {
        addCommands(new runRollerCommand().withTimeout(ROLLER_ROLLING_TIME_SEC), new stopRollerCommand());
    }
}
