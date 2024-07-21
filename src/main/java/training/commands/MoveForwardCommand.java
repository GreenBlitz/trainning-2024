package training.commands;

import edu.wpi.first.wpilibj2.command.Command;
import subsystem.ModuleSubsystem;
import training.Robot;

public class MoveForwardCommand extends Command {
    private final double speed;
    private final ModuleSubsystem subsystem;

    public MoveForwardCommand(double speed) {
        this.speed = speed;
        this.subsystem = Robot.getModuleSubsystem();
        this.addRequirements(subsystem);
    }

    @Override
    public void initialize() {
        subsystem.setAngularSpeed(0);
        subsystem.setLinearSpeed(speed);
    }

    @Override
    public void end(boolean interrupted) {
        subsystem.stopMotors();
    }
}
