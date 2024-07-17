package training.commands;

import edu.wpi.first.wpilibj2.command.Command;
import training.Robot;
import training.subsystems.movement.ModuleSubsystem;

public class SetAngle extends Command {
    private static final double ANGLE_ACCURACY = 0.05;
    private final double angle;
    private final double speed;
    private final ModuleSubsystem subsystem;

    public SetAngle(double angle, double speed) {
        this.angle = optimizeAngle(angle);
        this.speed = speed;
        this.subsystem = Robot.getModuleSubsystem();
        this.addRequirements(subsystem);
    }

    public SetAngle(double angle) {
        this.speed = 10;
        this.angle = optimizeAngle(angle);
        this.subsystem = Robot.getModuleSubsystem();
        this.addRequirements(subsystem);
    }

    public double optimizeAngle(double angle) {
        double currentAngle = subsystem.getRadAngle();
        int changeDirection;
        double aim = angle - currentAngle;

        if (aim % Math.PI != aim) {
            changeDirection = 1;
        } else {
            changeDirection = 0;
        }

        return (aim % Math.PI) * Math.pow((-1), changeDirection);
    }


    @Override
    public void initialize() {
        subsystem.setAngularSpeed(speed);
    }

    @Override
    public boolean isFinished() {
        return subsystem.isAtAngle(angle, ANGLE_ACCURACY);
    }

    @Override
    public void end(boolean interrupted) {
        subsystem.stopMotors();
    }

    @Override
    public void execute() {
        subsystem.setAngularSpeed(speed);
    }


}
