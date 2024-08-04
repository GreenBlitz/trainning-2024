package training.Roller;

import edu.wpi.first.math.geometry.Rotation2d;
import utils.GBSubsystem;

import static training.Roller.RollerConstants.ROLLER_DEFAULT_VELOCITY_RPM;
import static training.Roller.RollerConstants.ROLLER_LOG_PATH;
import static training.Roller.RollerDirection.kBackward;
import static training.Roller.RollerDirection.kForward;

public class Roller extends GBSubsystem {
    private Rotation2d targetVelocity;
    private RollerDirection direction;
    private final IRoller motor;

    public Roller() {
        this.motor = new RollerFactory().create();
        this.targetVelocity = Rotation2d.fromRotations(ROLLER_DEFAULT_VELOCITY_RPM);
    }

    public Rotation2d getTargetVelocity() {
        return targetVelocity;
    }

    public void setTargetVelocity(Rotation2d targetVelocity) {
        this.targetVelocity = targetVelocity;
    }

    public void runForward() {
        this.targetVelocity = Rotation2d.fromRotations(ROLLER_DEFAULT_VELOCITY_RPM);
        direction = kForward;
    }

    public void runBackward() {
        this.targetVelocity = Rotation2d.fromRotations(ROLLER_DEFAULT_VELOCITY_RPM);
        direction = kBackward;
    }

    public void stop() {
        targetVelocity = Rotation2d.fromRotations(0);
        motor.setPower(0);
    }

    @Override
    protected String getLogPath() {
        return ROLLER_LOG_PATH;
    }

    @Override
    protected void subsystemPeriodic() {
        motor.updateVelocity(targetVelocity, direction);
    }
}
