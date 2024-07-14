package training.commands;

import edu.wpi.first.wpilibj2.command.Command;
import training.Robot;
import training.subsystems.movement.ModuleSubsystem;

public class MoveForwardCommand extends Command {
    private double speed;
    private ModuleSubsystem subsystem;

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
