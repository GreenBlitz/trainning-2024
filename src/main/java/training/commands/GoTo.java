package training.commands;

import edu.wpi.first.wpilibj2.command.Command;
import training.Robot;
import training.subsystems.movement.ModuleSubsystem;

public class GoTo extends Command {
    private static final double ANGLE_ACCURACY = 0.05;
    protected static final double DEFAULT_ANGULAR_SPEED=0.05;
    private final double angle;
    private double speed;
    private final ModuleSubsystem module;

    public GoTo(double angle, double speed) {
        this.module = Robot.get();
        this.angle = angle % (2 * Math.PI);
        this.speed = speed;
        this.addRequirements(module);
    }

    public GoTo(double angle) {
        this(angle, DEFAULT_ANGULAR_SPEED);
        this.speed *= speedDirection(angle);
    }

    private int speedDirection(double angle) {
        double currentAngle = module.getRadAngle();
        double aim = angle - currentAngle;
        if (aim % (2 * Math.PI) != aim) {
            System.out.println(-1);
            return -1;
        } else {
            System.out.println(1);
            return 1;
        }
    }


    @Override
    public void initialize() {
        module.setAngularSpeed(speed);
    }

    @Override
    public void execute() {
        module.setAngularSpeed(speed);
    }


    @Override
    public boolean isFinished() {
        return module.isAtAngle(angle, ANGLE_ACCURACY);
    }

    @Override
    public void end(boolean interrupted) {
        module.stopMotors();
    }



}
