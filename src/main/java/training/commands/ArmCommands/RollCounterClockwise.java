package training.commands.ArmCommands;

import training.subsystems.ArmSubsystems.RollerPackage.Roller;

public class RollCounterClockwise {

    private final Roller roller;

    public RollCounterClockwise() {
        this.roller = Roller.getInstance();
    }

    public void initialize() {
        roller.rollBCounterClockwise();
    }

    public void end(boolean interrupted) {
        roller.stop();
    }
}
