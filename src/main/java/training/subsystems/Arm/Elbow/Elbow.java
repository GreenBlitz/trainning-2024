package training.subsystems.Arm.Elbow;

import edu.wpi.first.math.geometry.Rotation2d;
import org.littletonrobotics.junction.Logger;
import utils.GBSubsystem;

public class Elbow extends GBSubsystem {
    private final IElbow iElbow;

    public Elbow() {
        this.iElbow = ElbowFactory.create();
    }

    @Override
    protected String getLogPath() {
        return "";
    }

    @Override
    protected void subsystemPeriodic() {
        Logger.recordOutput("elbow position", iElbow.getPosition().getDegrees());
    }


    public void moveToAngle(Rotation2d position) {
        iElbow.moveToAngle(position);
    }

    public Rotation2d getPosition() {
        return iElbow.getPosition();
    }

    public void stopMotor() {
        iElbow.stopMotor();
    }

    public void standInPlace() {
        moveToAngle(getPosition());
    }

}
