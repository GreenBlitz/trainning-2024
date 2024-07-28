package commands;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import subsystems.wrist.Wrist;

public class SetWristAngleCommand extends Command {
    private final Rotation2d angle;
    private final Wrist wrist;

    public SetWristAngleCommand(Rotation2d angle) {
        wrist = Wrist.getInstance();
        addRequirements(wrist);

        this.angle = angle;
    }

    @Override
    public void execute() {
        wrist.getToPosition(angle);
    }
}