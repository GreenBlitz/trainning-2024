package subsystems.elbow;

import edu.wpi.first.math.geometry.Rotation2d;

public class Elbow implements IElbow {

    private IElbow iElbow;

    public Elbow(){
        iElbow =Factory.create();
    }

    @Override
    public Rotation2d getAngle() {
        return iElbow.getAngle();
    }

    @Override
    public double getRPMVelocity() {
        return iElbow.getRPMVelocity();
    }

    @Override
    public void setPower(double power) {
        iElbow.setPower(power);
    }

    @Override
    public void goToPosition(Rotation2d position) {
        iElbow.goToPosition(position);
    }
}
