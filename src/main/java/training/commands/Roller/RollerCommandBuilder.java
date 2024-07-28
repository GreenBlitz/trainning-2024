package training.commands.Roller;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import training.subsystems.Roller.Roller;

public class RollerCommandBuilder extends Command {
    private final Roller roller;

    public RollerCommandBuilder() {
        roller = Roller.getInstance();
        addRequirements(roller);
    }

    public Command RollerStopCommand() {
        return new InstantCommand(roller::stop);
    }
}
