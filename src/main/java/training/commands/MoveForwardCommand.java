package training.commands;

import edu.wpi.first.wpilibj2.command.Command;
import training.Robot;
import training.subsystems.movement.ModuleSubsystem;

public class MoveForwardCommand extends Command {
    private final double speed;
    private final ModuleSubsystem module;

    public MoveForwardCommand(double speed) {
        this.speed = speed;
        this.module = Robot.get();
        this.addRequirements(module);
    }

    @Override
    public void initialize() {
        module.setAngularSpeed(0);
        module.setLinearSpeed(speed);
    }

    @Override
    public void end(boolean interrupted) {
        module.stopMotors();
    }
}
