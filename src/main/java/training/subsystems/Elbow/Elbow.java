package training.subsystems.Elbow;

import edu.wpi.first.math.geometry.Rotation2d;
import org.littletonrobotics.junction.Logger;
import utils.GBSubsystem;

public class Elbow extends GBSubsystem {
    private final IElbow elbow;

    public Elbow() {
        elbow = ElbowFactory.create();
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
