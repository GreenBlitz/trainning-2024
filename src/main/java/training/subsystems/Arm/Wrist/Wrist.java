package training.subsystems.Arm.Wrist;

import edu.wpi.first.math.geometry.Rotation2d;
import org.littletonrobotics.junction.Logger;
import utils.GBSubsystem;

public class Wrist extends GBSubsystem {
    private final IWrist elbow;

    public Wrist() {
        elbow = WristFactory.create();
    }

    @Override
    protected String getLogPath() {
        return "";
    }

    @Override
    protected void subsystemPeriodic() {
        Logger.recordOutput("elbow position", elbow.getPosition().getDegrees());
    }


    public void moveToAngle(Rotation2d position) {
        elbow.moveToAngle(position);
    }

    public Rotation2d getPosition() {
        return elbow.getPosition();
    }

    public void stopMotor() {
        elbow.stopMotor();
    }

    public void standInPlace() {
        moveToAngle(getPosition());
    }

}
