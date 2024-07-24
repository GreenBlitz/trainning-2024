package training.commands.ArmCommands;

import training.subsystems.ArmSubsystems.Roller;

public class rollerBackward {

    Roller roller;

    public rollerBackward(Roller roller){
        this.roller=roller;
    }

    public void initialize() {
        roller.reversRoller();
    }


    public void end(boolean interrupted) {
        roller.stopRoller();
    }
}
