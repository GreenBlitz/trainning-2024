package training.subsystems.Arm.Wrist;

import edu.wpi.first.math.geometry.Rotation2d;
import org.littletonrobotics.junction.Logger;
import utils.GBSubsystem;

public class Wrist extends GBSubsystem {
    private final IWrist wrist;

    public Wrist() {
        wrist = WristFactory.create();
    }

    @Override
    protected String getLogPath() {
        return "";
    }

    @Override
    protected void subsystemPeriodic() {
        Logger.recordOutput("wrist position", wrist.getPosition().getDegrees());
    }


    public void moveToAngle(Rotation2d position) {
        wrist.moveToAngle(position);
    }

    public Rotation2d getPosition() {
        return wrist.getPosition();
    }

    public void stopMotor() {
        wrist.stopMotor();
    }

    public void standInPlace() {
        moveToAngle(getPosition());
    }

}
