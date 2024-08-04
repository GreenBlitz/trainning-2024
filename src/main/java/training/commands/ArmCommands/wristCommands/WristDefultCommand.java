package training.commands.ArmCommands.wristCommands;

import edu.wpi.first.wpilibj2.command.Command;
import training.subsystems.ArmSubsystems.wristSubsystem.Wrist;

public class WristDefultCommand extends Command {
    private Wrist wrist;

    public WristDefultCommand() {
        wrist = Wrist.getInstance();
        addRequirements(wrist);
    }

    @Override
    public void initialize() {
        wrist.stopMotor();
    }

    @Override
    public void end(boolean interrupted) {
        super.end(interrupted);
    }

}
