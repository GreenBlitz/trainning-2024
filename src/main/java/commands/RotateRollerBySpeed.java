package commands;

import edu.wpi.first.wpilibj2.command.Command;
import subsystems.Roller.Roller;

public class RotateRollerBySpeed extends Command {
    private final double rotationalSpeed;
    private final Roller roller;

    public RotateRollerBySpeed(double speed){
        roller=Roller.getInstance();
        addRequirements(roller);

        rotationalSpeed=speed;
    }

    @Override
    public void execute() {
        roller.setRotationalSpeed(rotationalSpeed);
    }
}
