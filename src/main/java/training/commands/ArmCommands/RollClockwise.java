package training.commands.ArmCommands;

import training.subsystems.ArmSubsystems.RollerPackage.Roller;

public class RollClockwise {
    private final Roller roller;

    public RollClockwise() {
        this.roller = Roller.getInstance();
    }

    public void initialize() {
        roller.rollForward();
    }

    public void end(boolean interrupted) {
        roller.stop();
    }
}
