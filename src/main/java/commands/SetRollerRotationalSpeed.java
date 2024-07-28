package commands;

import edu.wpi.first.wpilibj2.command.Command;
import subsystems.Roller.Roller;

public class SetRollerRotationalSpeed extends Command {
    private final double rotationalSpeed;
    private final Roller roller;

    public SetRollerRotationalSpeed(double speed){
        roller=Roller.getInstance();
        addRequirements(roller);

        rotationalSpeed=speed;
    }

    @Override
    public void execute() {
        roller.setRotationalSpeed(rotationalSpeed);
    }
}
