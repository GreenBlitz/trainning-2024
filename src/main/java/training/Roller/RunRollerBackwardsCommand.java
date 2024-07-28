package training.Roller;

import edu.wpi.first.wpilibj2.command.Command;

public class RunRollerBackwardsCommand extends Command {
    private final Roller roller;

    public RunRollerBackwardsCommand() {
        this.roller = Roller.getInstance();
        addRequirements(roller);
    }

    @Override
    public void execute() {
        roller.runForward();
    }
}
