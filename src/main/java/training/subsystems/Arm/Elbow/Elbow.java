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
        Logger.recordOutput("Elbow/Position", iElbow.getPosition().getDegrees());
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

    public boolean isAtAngle(Rotation2d angle) {
        return Math.abs(getPosition().getRotations() - angle.getRotations()) % 1 <= ElbowConstants.ANGULAR_TOLERANCE.getRotations();
    }

}
