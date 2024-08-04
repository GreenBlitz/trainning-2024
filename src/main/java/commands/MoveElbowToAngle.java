package commands;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import subsystems.elbow.neoElbow.NeoElbow;

public class MoveElbowToAngle extends Command {
    private final Rotation2d angle;
    private final NeoElbow elbow;

    public MoveElbowToAngle(Rotation2d angle) {
        elbow = NeoElbow.getInstance();
        addRequirements(elbow);

        this.angle = angle;
    }

    @Override
    public void execute() {
        elbow.goToPosition(angle);
    }

}
