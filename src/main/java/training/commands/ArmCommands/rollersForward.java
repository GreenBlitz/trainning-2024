package training.commands.ArmCommands;

import training.subsystems.ArmSubsystems.Roller;

public class rollersForward {
    Roller roller;

    public rollersForward(Roller roller){
        this.roller=roller;
    }

    public void initialize() {
        roller.moveRoller();
    }


    public void end(boolean interrupted) {
        roller.stopRoller();
    }
}
