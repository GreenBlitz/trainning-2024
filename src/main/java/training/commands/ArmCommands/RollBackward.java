package training.commands.ArmCommands;

import training.subsystems.ArmSubsystems.Roller;

public class RollBackward {

    private final Roller roller;

    public RollBackward(Roller roller){
        this.roller=roller;
    }

    public void initialize() {
        roller.rollBackward();
    }


    public void end(boolean interrupted) {
        roller.stopRoller();
    }
}
