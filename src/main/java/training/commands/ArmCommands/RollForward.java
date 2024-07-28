package training.commands.ArmCommands;

import training.subsystems.ArmSubsystems.Roller;

public class RollForward {
    private final Roller roller;

    public RollForward(Roller roller){
        this.roller=roller;
    }

    public void initialize() {
        roller.rollForward();
    }


    public void end(boolean interrupted) {
        roller.stopRoller();
    }
}
