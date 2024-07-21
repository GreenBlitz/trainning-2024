package training.commands;

import edu.wpi.first.wpilibj2.command.Command;
import subsystem.ModuleSubsystem;
import training.Robot;

public class GotoAngle extends Command {
    private static final double ANGLE_ACCURACY = 0.05;
    private final double angle;
    private final double speed;
    private final ModuleSubsystem subsystem;

    public GotoAngle(double angle, double speed) {
        this.subsystem = Robot.getModuleSubsystem();
        this.angle = angle % (2 * Math.PI);
        this.speed = speed;
        this.addRequirements(subsystem);
    }

    public GotoAngle(double angle) {
        this.subsystem = Robot.getModuleSubsystem();
        this.angle = angle % (2 * Math.PI);
        this.speed = Constants.DEFAULT_ANGULAR_SPEED * speedDirection(angle);
        this.addRequirements(subsystem);
    }

    private int speedDirection(double angle) {
        double currentAngle = subsystem.getRadAngle();
        int changeDirection;
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
