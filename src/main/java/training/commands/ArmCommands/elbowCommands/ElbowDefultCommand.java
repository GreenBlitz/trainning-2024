package training.commands.ArmCommands.elbowCommands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import training.subsystems.ArmSubsystems.elbowSubsystem.Elbow;
import training.subsystems.ArmSubsystems.elbowSubsystem.neoElbow.NeoElbow;

public class ElbowDefultCommand extends Command {
    private Elbow elbow;

    public ElbowDefultCommand() {
        elbow = Elbow.getInstance();
        addRequirements(elbow);
    }

    @Override
    public void initialize() {
        elbow.stayAtPosition();
    }

    @Override
    public void end(boolean interrupted) {
        super.end(interrupted);
    }

}
