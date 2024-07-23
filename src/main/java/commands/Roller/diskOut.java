package commands.Roller;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

import static commands.Roller.Constants.ROLLER_ROLLING_TIME_SEC;

public class diskOut extends SequentialCommandGroup {
    public diskOut() {
        addCommands(new runRoller().withTimeout(ROLLER_ROLLING_TIME_SEC), new stopRoller());
    }
}
