package commands.Elbow;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

public class LiftElbow extends SequentialCommandGroup {
    public LiftElbow() {
        addCommands(new UpElbow(), new WaitCommand(0.1), new DownElbow());
    }

    public LiftElbow(Rotation2d angle) {
        addCommands(new UpElbow(angle), new WaitCommand(0.1), new DownElbow(angle));
    }


}
